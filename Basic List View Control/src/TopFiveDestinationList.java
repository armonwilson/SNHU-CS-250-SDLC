/*
 * Armon Wilson
 * SNHU
 * CS-250
 * Basic List View Control - Top Five Destinations
 */


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

// ADDITION
//Imported classes for handling list selection events 
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class TopFiveDestinationList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
                topDestinationListFrame.setTitle("Top 5 Destination List");
                topDestinationListFrame.setVisible(true);
            }
        });
    }
}

class TopDestinationListFrame extends JFrame {
    private DefaultListModel listModel;

    public TopDestinationListFrame() {
        super("Top Five Destination List");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       
        // MODIFICATION
        // Modified size from 750 to 805
        setSize(900, 805);

        listModel = new DefaultListModel<TextAndIcon>();
        
        //ADDITION
     // Updated method call to include description and URL along with the destination name and picture. 
     // JPEG Images sized to 259x149.
        addDestinationNameAndPicture("Top Destination - Mobile, Alabama<br>", 
            "Mobile, Alabama, located along the Gulf Coast, is renowned for its rich history,"
            		+  "<br> cultural diversity, and vibrant Southern charm. As the birthplace of Mardi Gras"
            		+ "<br> in the United States, the city boasts a unique blend of historic architecture,"
            		+  "<br> scenic waterfronts, and a lively arts scene.<br>",
            "https://www.orbitz.com/Mobile.d602984.Destination-Travel-Guides",
            new ImageIcon(getClass().getResource("/resources/MobileAL.jpg")));

        addDestinationNameAndPicture("2nd Top Destination - Las Vegas, Nevada<br>",
            "Las Vegas, often referred to as the \"Entertainment Capital of the World,\" is a vibrant city in the"
                    + " <br>Nevada desert known for its world-renowned resorts, bustling casinos, and extravagant"
                    + " <br>entertainment shows. Renowned for its lively nightlife on the iconic Las Vegas Strip, the city is a"
                    + " <br>global destination for entertainment, gaming, and luxury experiences.<br>",
            "https://www.orbitz.com/Las-Vegas.d178276.Destination-Travel-Guides",
            new ImageIcon(getClass().getResource("/resources/LasVegasNV.jpg")));

        addDestinationNameAndPicture("3rd Top Destination - San Antonio, Texas<br>",
            "San Antonio, located in the heart of Texas, is a city rich in history and cultural diversity. Home to the"
                    + " <br>iconic Alamo, the scenic River Walk, and vibrant Mexican-influenced cuisine, San Antonio offers a"
                    + " <br>blend of historic charm and modern attractions.<br>",
            "https://www.orbitz.com/San-Antonio.d178303.Destination-Travel-Guides",
            new ImageIcon(getClass().getResource("/resources/SanAntonioTX.jpg")));

        addDestinationNameAndPicture("4th Top Destination - Key West, Florida<br>",
            "Key West, the southernmost city in the United States, is a tropical paradise nestled at the end of the"
                    + " <br>Florida Keys. Known for its laid-back atmosphere, colorful architecture, and vibrant sunsets, Key"
                    + " <br>West is a haven for water activities, historic sites, and a lively arts scene.<br>",
            "https://www.orbitz.com/Key-West.d1187.Destination-Travel-Guides",
            new ImageIcon(getClass().getResource("/resources/KeyWestFL.jpg")));

        addDestinationNameAndPicture("5th Top Destination - Nashville, Tennessee<br>",
            "Nashville, the capital of Tennessee, is renowned as the \"Music City\" for its pivotal role in the country"
                    + " <br>music industry. Boasting a lively honky-tonk scene on Broadway, historic landmarks like the Grand"
                    + " <br>Ole Opry, and a rich cultural tapestry, Nashville is a dynamic blend of musical heritage and Southern"
                    + " <br>charm.<br>",
            "https://www.orbitz.com/Downtown-Nashville.d6059741.Destination-Travel-Guides",
            new ImageIcon(getClass().getResource("/resources/NashvilleTN.jpg")));

        JList<TextAndIcon> list = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);
        
     // ADDITION   
     // Added a ListSelectionListener to open the URL in the browser when an item is selected. Adds mouse input recognition. 
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = list.getSelectedIndex();
                    if (selectedIndex != -1) {
                        TextAndIcon selectedDestination = (TextAndIcon) listModel.getElementAt(selectedIndex);
                        openUrlInBrowser(selectedDestination.getUrl());
                    }
                }
            }
        });

        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(2);
        
        list.setCellRenderer(renderer);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
    
    // ADDITION
    // Updated method signature to include description and URL 
    private void addDestinationNameAndPicture(String text, String description, String url, Icon icon) {
        TextAndIcon tai = new TextAndIcon(text, description, url, icon);
        listModel.addElement(tai);
    }
    
    //ADDITION
    // Added a method to open the URL in the default web browser. Error handling implemented in cases where
    // desktop method is not supported.
    private void openUrlInBrowser(String url) {
        try {
        	// IF desktop access is supported, launch default browser and the hyperlinks
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TextAndIcon {
    private String text;
    
    // ADDITION
    // Updated, url & description added
    private String description;
    private String url;
    
    private Icon icon;
    
    // ADDITIONS
    // Updated constructor to include description and URL parameter
    public TextAndIcon(String text,String description,String url, Icon icon) {
        this.text = text;
        this.icon = icon;
        
        // ADDITION
        // Updated, added url & description
        this.description = description;
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }
    
    // ADDITION
    //new accessor for url
    public String getUrl() {
    	return url;
    }
    
    // ADDITION
    //new accessor for description
    public String getDescription() {
    	return description;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
    
    // ADDITION
    //new constructor for description
    public void setDescription(String description) {
    	this.description = description;
    }
    
    // ADDITION
    //new constructor for url
    public void setUrl(String url) {
    	this.url = url;
    }
}


class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer {
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

    private Border insideBorder;

    public TextAndIconListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public TextAndIconListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }
    
    public Component getListCellRendererComponent(JList list, Object value,
    	    int index, boolean isSelected, boolean hasFocus) {
        // The object from the combo box model MUST be a TextAndIcon.
        TextAndIcon tai = (TextAndIcon) value;

        // Sets text and icon on 'this' JLabel. 
        
        // ADDITION
        // Modified to add description & url.
        setText("<html><b>" + tai.getText() + "</b><br>" + tai.getDescription() + "</html>");
        setIcon(tai.getIcon());

        
        

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        Border outsideBorder;

        if (hasFocus) {
            outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    // The following methods are overridden to be empty for performance
    // reasons. If you want to understand better why, please read:
    //
    // http://java.sun.com/javase/6/docs/api/javax/swing/DefaultListCellRenderer.html#override

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}