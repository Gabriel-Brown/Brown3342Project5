/******************************************************
‘***  Project 5 - Serialization
‘******************************************************
‘*** To Demonstrate Serialization
‘***
‘******************************************************
‘*** 11/29/2017
‘******************************************************
‘*****************************************************/
package brown3342project4;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Gabe
 */


public class StoreGUI extends JFrame {
    public Vector<StoreItem> storeItems = new Vector<StoreItem>();
    public static final String FILENAME = "file.ser";
    JPanel pnlDefault = new JPanel();
    JLabel lblTitle = new JLabel("         Title:");
    JTextField txtTitle = new JTextField("",15);
    JLabel lblAuthor = new JLabel("        Author:");
    JTextField txtAuthor = new JTextField("",15);
    JLabel lblDate = new JLabel("  Date Aquired:");
    JXDatePicker txtDate = new JXDatePicker();
    JLabel lblPurPrice = new JLabel("Purchase Price:");
    JTextField txtPurPrice = new JTextField("",15);
    JLabel lblAskPrice = new JLabel("  Asking Price:");
    JTextField txtAskPrice = new JTextField("",15);
    JRadioButton rbBook = new JRadioButton( "Book", true );
    JRadioButton rbMovie = new JRadioButton( "Movie", false );
    JRadioButton rbPainting = new JRadioButton( "Painting", false );
    ButtonGroup radioGroup = new ButtonGroup();
    
    JLabel lblError = new JLabel(" ");
    
    JPanel pnlBook = new JPanel();
    JLabel lblGenre = new JLabel("         Genre:");
    JTextField txtGenre = new JTextField("",15);
    JButton btnBook = new JButton("Add Book");
    
    JPanel pnlMovie = new JPanel();
    JLabel lblDirector = new JLabel("      Director:");
    JTextField txtDirector = new JTextField("",15);
    JLabel lblActors = new JLabel("      Actor(s):");
    JTextField txtActors = new JTextField("",15);
    JLabel lblActress = new JLabel("   Actress(es):");
    JTextField txtActress = new JTextField("",15);
    JButton btnMovie = new JButton("Add Movie");
    
    JPanel pnlPainting = new JPanel();
    JLabel lblHeight = new JLabel("        Height:");
    JTextField txtHeight = new JTextField("",15);
    JLabel lblWidth = new JLabel("         Width:");
    JTextField txtWidth = new JTextField("",15);
    JLabel lblMedia = new JLabel("         Media:");
    JTextField txtMedia = new JTextField("",15);
    JButton btnPainting = new JButton("Add Painting");
    
    JPanel pnlDisplay = new JPanel();
    JList lstBooks = new JList();
    JList lstMovies = new JList();
    JList lstPaintings = new JList();
    JLabel lblInfo = new JLabel("Add and Select an item to view it's information");
    
        public StoreGUI() {
		super("Project 4");
                
		setLayout(new FlowLayout());
                Font plainFont = new Font( "monospaced", Font.BOLD, 14 ); 
                pnlDefault.setPreferredSize( new Dimension(300, 170) );
                lblTitle.setFont(plainFont);
                lblAuthor.setFont(plainFont);
                lblDate.setFont(plainFont);
                lblPurPrice.setFont(plainFont);
                lblAskPrice.setFont(plainFont);
                lblGenre.setFont(plainFont);
                lblDirector.setFont(plainFont);
                lblActors.setFont(plainFont);
                lblActress.setFont(plainFont);
                lblHeight.setFont(plainFont);
                lblWidth.setFont(plainFont);
                lblMedia.setFont(plainFont);
                lblInfo.setFont(plainFont);
                
                
                pnlDefault.add(lblTitle);pnlDefault.add(txtTitle);
                pnlDefault.add(lblAuthor);pnlDefault.add(txtAuthor);
                pnlDefault.add(lblDate);pnlDefault.add(txtDate);
                txtDate.setPreferredSize(new Dimension(170, 20));
                pnlDefault.add(lblPurPrice);pnlDefault.add(txtPurPrice);
                pnlDefault.add(lblAuthor);pnlDefault.add(txtAuthor);
                pnlDefault.add(lblAskPrice);pnlDefault.add(txtAskPrice);
                radioGroup.add(rbBook);
                radioGroup.add(rbMovie);
                radioGroup.add(rbPainting);
                pnlDefault.add(rbBook);
                pnlDefault.add(rbMovie);
                pnlDefault.add(rbPainting);
                
                pnlBook.setPreferredSize( new Dimension(300, 120) );
                pnlBook.add(lblGenre);pnlBook.add(txtGenre);
                pnlBook.add(btnBook);
                
                pnlMovie.setPreferredSize( new Dimension(300, 120) );
                pnlMovie.add(lblDirector);pnlMovie.add(txtDirector);
                pnlMovie.add(lblActors);pnlMovie.add(txtActors);
                pnlMovie.add(lblActress);pnlMovie.add(txtActress);
                pnlMovie.add(btnMovie);
                pnlMovie.setVisible(false);
                
                pnlPainting.setPreferredSize( new Dimension(300, 120) );
                pnlPainting.add(lblHeight);pnlPainting.add(txtHeight);
                pnlPainting.add(lblWidth);pnlPainting.add(txtWidth);
                pnlPainting.add(lblMedia);pnlPainting.add(txtMedia);
                pnlPainting.add(btnPainting);
                pnlPainting.setVisible(false);
                
                pnlDisplay.setPreferredSize( new Dimension(800, 200) );
                pnlDisplay.add(lstBooks);
                pnlDisplay.add(lstMovies);
                pnlDisplay.add(lstPaintings);
                pnlDisplay.add(lblInfo);
                
                rbBook.addItemListener( new RadioButtonHandler( 1 ) ); 
                rbMovie.addItemListener( new RadioButtonHandler( 2 ) ); 
                rbPainting.addItemListener( new RadioButtonHandler( 3 ) ); 
                add(pnlDefault);
                add(pnlBook);
                add(pnlMovie);
                add(pnlPainting);
                add(pnlDisplay);
                //add(jButton1);
                
                btnBook.addActionListener(new ButtonHandler(1));
                btnMovie.addActionListener(new ButtonHandler(2));
                btnPainting.addActionListener(new ButtonHandler(3));
                
                lstBooks.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        lstBooksMousePressed(evt);
                    }   
                });
                
                lstMovies.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        lstMoviesMousePressed(evt);
                    }   
                });
                
                lstPaintings.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        lstPaintingsMousePressed(evt);
                    }   
                });
                
                // Deserialization
                try
                {   
                    // Reading the object from a file
                    FileInputStream file = new FileInputStream(FILENAME);
                    ObjectInputStream in = new ObjectInputStream(file);

                    // Method for deserialization of object
                    storeItems = (Vector<StoreItem>)in.readObject();

                    in.close();
                    file.close();

                    System.out.println("Object has been deserialized ");
                    
                }

                catch(IOException ex)
                {
                    System.out.println("IOException is caught");
                }

                catch(ClassNotFoundException ex)
                {
                    System.out.println("ClassNotFoundException is caught");
                }
                
                Vector<String> booktitles  = new Vector<String>();
                Vector<String> movietitles  = new Vector<String>();
                Vector<String> painttitles  = new Vector<String>();

                for (StoreItem item: storeItems)
                {
                    if (item instanceof Book)
                        booktitles.add(item.getTitle());
                    if (item instanceof Movie)
                        movietitles.add(item.getTitle());
                    if (item instanceof Painting)
                        painttitles.add(item.getTitle());
                        
                }
                lstBooks.setListData(booktitles);
                lstMovies.setListData(movietitles);
                lstPaintings.setListData(painttitles);

        }
        
    private void lstBooksMousePressed(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
        String display = "<html><b>Book Properties:</b><br>";
        int selected = lstBooks.getSelectedIndex();
        display += displayStoreItem(Book.class ,selected);
        lblInfo.setText(display); 
        lstMovies.clearSelection();
        lstPaintings.clearSelection();
    }   
    
    private void lstMoviesMousePressed(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
        String display = "<html><b>Movie Properties:</b><br>";
        int selected = lstMovies.getSelectedIndex();
        display += displayStoreItem(Movie.class ,selected);
        lblInfo.setText(display); 
        lstBooks.clearSelection();
        lstPaintings.clearSelection();
    }   
    
    private void lstPaintingsMousePressed(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
        String display = "<html><b>Painting Properties:</b><br>";
        int selected = lstPaintings.getSelectedIndex();
        display += displayStoreItem(Painting.class ,selected);
        lblInfo.setText(display); 
        lstMovies.clearSelection();
        lstBooks.clearSelection();
    }   
        
    public String validateStoreItem(String title, String author, 
        Date[] dateAcquired, int[] purchasePrice, int[] askingPrice)
    {
        String error = "";
        
        try {askingPrice[0] = Integer.parseInt(txtAskPrice.getText());}
        catch(Exception ex) {error = "Error: Asking Price could not be converted to a counting number.";}
        
        try {purchasePrice[0] = Integer.parseInt(txtPurPrice.getText());}
        catch(Exception ex) {error = "Error: Purchase Price could not be converted to a counting number.";}
                
        if (txtDate.getDate() != null)
            dateAcquired[0] = txtDate.getDate();
        else
            error = "Error: Item must have a date.";
        
        if (author.compareTo("") == 0) error = "Error: Item must have an author.";
        if (title.compareTo("") == 0) error = "Error: Item must have a title.";
        
        return error;
    }
    
    private String displayStoreItem(Class<?> cls,int index) 
    {
        String display = "";
        for (StoreItem item: storeItems)
            {
                if (cls.isInstance(item))
                {//(String title, String author, Date dateAcquired, int purchasePrice, int askingPrice, String genre )
                    if(index-- == 0)
                    {
                        display += "Title..........." + item.getTitle() + "<br>";
                        display += "Author.........." + item.getAuthor() + "<br>";
                        display += "Date Acquired..." + new SimpleDateFormat("MM-dd-yyyy").format(item.getDateAcquired()) + "<br>";
                        display += "Purchase Price.." + item.getPurchasePrice() + "<br>";
                        display += "Asking Price...." + item.getAskingPrice() + "<br>";
                        if (item instanceof Book)
                            display += "Genre..........." + ((Book) item).getGenre() + "<br>";
                        if (item instanceof Movie){
                            display += "Director........" + ((Movie) item).getDirector() + "<br>";
                            display += "Actor(s)........" + Arrays.toString(((Movie) item).getActors()) + "<br>";
                            display += "Actress(es)....." + Arrays.toString(((Movie) item).getActresses()) + "<br>";
                        }
                        if (item instanceof Painting){
                            display += "Height.........." + ((Painting) item).getHeight()+ "<br>";
                            display += "Width..........." + ((Painting) item).getWidth()+ "<br>";
                            display += "Media..........." + ((Painting) item).getMedia()+ "<br>";
                        }

                    }
                }
            }
        return display;
    }
        
    private class ButtonHandler implements ActionListener {
        private int button; // font associated with this listene
        public ButtonHandler( int b ){ button = b; }
      
	public void actionPerformed(ActionEvent e) {
            String error = "";
            Date[] dateAcquired = new Date[1];
            int[] purchasePrice = new int[1];
            int[] askingPrice = new int[1];
            String title = txtTitle.getText().trim();
            String author = txtAuthor.getText().trim();
            switch (button) {
              case 1:
                    //Book (String title, String author, Date dateAcquired, int purchasePrice, int askingPrice, String genre )

                    String genre = txtGenre.getText().trim();

                    error = validateStoreItem(title, author, dateAcquired, purchasePrice, askingPrice);

                    if (error.compareTo("") == 0 && genre.compareTo("") == 0) 
                        error = "Error: Item must have a genre.";

                    lblError.setText(error);


                    if ( error.compareTo("") == 0 )
                    {
                        storeItems.add(new Book(title,author,dateAcquired[0],purchasePrice[0],askingPrice[0],genre));
                    }

                    Vector<String> booktitles  = new Vector<String>();

                    for (StoreItem item: storeItems)
                    {
                        if (item instanceof Book)
                            booktitles.add(item.getTitle());
                            //jList1.setModel(((DefaultListModel) jList1.getModel()).addElement(((Book) item).getGenre()));
                    }
                    lstBooks.setListData(booktitles);
                  break;
              case 2:
                    String director = txtDirector.getText().trim();
                    String actors = txtActors.getText().trim();
                    String actresses = txtActress.getText().trim();

                    error = validateStoreItem(title, author, dateAcquired, purchasePrice, askingPrice);

                    if (error.compareTo("") == 0 && director.compareTo("") == 0) 
                        error = "Error: Item must have a director.";

                    if (error.compareTo("") == 0 && actors.compareTo("") == 0) 
                        error = "Error: Item must have at least one actor.";

                    if (error.compareTo("") == 0 && actresses.compareTo("") == 0) 
                        error = "Error: Item must have at least one actress.";


                    lblError.setText(error);


                    if ( error.compareTo("") == 0 )
                    {
                        storeItems.add(new Movie(title,author,dateAcquired[0],purchasePrice[0],askingPrice[0],director,actors.split(", "),actresses.split(", ")));
                    }

                    Vector<String> movietitles  = new Vector<String>();

                    for (StoreItem item: storeItems)
                    {
                        if (item instanceof Movie)
                            movietitles.add(item.getTitle());
                            //jList1.setModel(((DefaultListModel) jList1.getModel()).addElement(((Book) item).getGenre()));
                    }
                    lstMovies.setListData(movietitles);
                    break;
              case 3:
                int height = 0;
                int width = 0;
                String media = txtMedia.getText().trim();

                if (media.compareTo("") == 0) 
                    error = "Error: Item must have a media.";

                try{width = Integer.parseInt(txtWidth.getText());}
                catch(Exception ex) {error = "Error: Width could not be converted to a counting number";}

                try{height = Integer.parseInt(txtHeight.getText());}
                catch(Exception ex) {error = "Error: Height could not be converted to a counting number";}

                if ( error.compareTo("") == 0 )
                {
                    error = validateStoreItem(title, author, dateAcquired, purchasePrice, askingPrice);
                }
                lblError.setText(error);


                if ( error.compareTo("") == 0 )
                {
                    storeItems.add(new Painting(title,author,dateAcquired[0],purchasePrice[0],askingPrice[0],height,width,media));
                }

                Vector<String> paintTitles  = new Vector<String>();

                for (StoreItem item: storeItems)
                {
                    if (item instanceof Painting)
                        paintTitles.add(item.getTitle());
                }
                lstPaintings.setListData(paintTitles);
                  break;
          }
		//Serialize to file
            
         
            // Serialization 
            try
            {   
                //Saving of object in a file
                FileOutputStream file = new FileOutputStream(FILENAME);
                ObjectOutputStream out = new ObjectOutputStream(file);

                // Method for serialization of object
                out.writeObject(storeItems);

                out.close();
                file.close();

                System.out.println("Object has been serialized");

            }
            catch(IOException ex)
            {
                System.out.println("IOException is caught");
            }
	}
    }
        
        // private inner class to handle radio button events
   private class RadioButtonHandler implements ItemListener 
   {
      private int radio; // font associated with this listene
      public RadioButtonHandler( int rb ){ radio = rb; }
      
           
      // handle radio button events
      public void itemStateChanged( ItemEvent event )
      {
          switch (radio) {
              case 1:
                  pnlBook.setVisible(true);
                  pnlMovie.setVisible(false);
                  pnlPainting.setVisible(false);
                  break;
              case 2:
                  pnlBook.setVisible(false);
                  pnlMovie.setVisible(true);
                  pnlPainting.setVisible(false);
                  break;
              case 3:
                  pnlMovie.setVisible(false);
                  pnlBook.setVisible(false);
                  pnlPainting.setVisible(true);
                  break;
          }
      } // end method itemStateChanged
   } // end private inner class RadioButtonHandler
    
}
