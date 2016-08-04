import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.picking.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.net.URL.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.MalformedURLException.*;
import java.awt.image.*;
import javax.imageio.*;



public class SolarSis extends MouseAdapter {	


protected Transform3D viewTransform = new Transform3D();
protected Vector3f viewVector;
protected ViewingPlatform vp = null;
protected TransformGroup viewTG = null;
//private TransformGroup riderPos;
//******************************TG ROTAR*************************************
private TransformGroup solRotX;
private TransformGroup merRotX;
private TransformGroup venuRotX;
private TransformGroup earthRotX;
private TransformGroup lunaRotX;
private TransformGroup marteRotX;
private TransformGroup jupiRotX;
private TransformGroup satRotX;
private TransformGroup anilloRotX;
private TransformGroup uranRotX;
private TransformGroup nepRotX;
private TransformGroup pluRotX;

//*********************************TG TRANS***********************************
private TransformGroup merTransX;
private TransformGroup venuTransX;
private TransformGroup earthTransX;
private TransformGroup lunaTransX;
private TransformGroup marteTransX;
private TransformGroup jupiTransX;
private TransformGroup satTransX;
private TransformGroup uranTransX;
private TransformGroup nepTransX;
private TransformGroup pluTransX;

SimpleUniverse universe;
private PickCanvas pickCanvas;
//DISEÑO.......
private JComboBox jcb;
private JTextArea jta;//mostrar texto
final JEditorPane jt ;//para el html
private JLabel label;
private JPanel panel;
private ImageIcon image;
private JFrame f;
private Button btn;
private JScrollPane pane;
private JPanel panel2;

public SolarSis(){	 

    
	BranchGroup group = new BranchGroup();

    //***************************************Apariencias**************************
	Appearance appsol = new Appearance();
    Appearance appmer = new Appearance();
    Appearance appvenu = new Appearance();
    Appearance appearth = new Appearance();
    Appearance appluna = new Appearance();
    Appearance appmarte = new Appearance();
    Appearance appjupi = new Appearance();
    Appearance appsat = new Appearance();
    Appearance appuran = new Appearance();
    Appearance appnep = new Appearance();
    Appearance appplu = new Appearance();
    Appearance app= new Appearance();

    //*********************************TEXTURAS*****************************

    TextureLoader tex=new TextureLoader("SOL.JPG", null);//obtenemos textura
    appsol.setTexture(tex.getTexture());//colocamos textura
    tex=new TextureLoader("MERCURIO.JPG", null);
    appmer.setTexture(tex.getTexture());
    tex=new TextureLoader("VENUS.JPG", null);
    appvenu.setTexture(tex.getTexture());
    tex=new TextureLoader("TIERRA.JPG", null);
    appearth.setTexture(tex.getTexture());
    tex=new TextureLoader("LUNA.JPG", null);
    appluna.setTexture(tex.getTexture());
    tex=new TextureLoader("MARTE.JPG", null);
    appmarte.setTexture(tex.getTexture());
    tex=new TextureLoader("JUPITER.JPG", null);
    appjupi.setTexture(tex.getTexture());
    tex=new TextureLoader("SATURNO.JPG", null);
    appsat.setTexture(tex.getTexture());
    tex=new TextureLoader("URANO.JPG", null);
    appuran.setTexture(tex.getTexture());
    tex=new TextureLoader("NEPTUNO.JPG", null);
    appnep.setTexture(tex.getTexture());
    tex=new TextureLoader("PLUTON.JPG", null);
    appplu.setTexture(tex.getTexture());
    TextureLoader texlo= new TextureLoader("ANILLOS.JPG", null);
    app.setTexture(texlo.getTexture());

    //*************************ESFERAS*************************************

    int primflags= Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;

    Sphere sol = new Sphere(0.17f, Primitive.GENERATE_NORMALS | 
    Primitive.GENERATE_TEXTURE_COORDS, 32, appsol);
    sol.setUserData("Sol");
    Sphere mer = new Sphere(0.020f, Primitive.GENERATE_NORMALS |            
    Primitive.GENERATE_TEXTURE_COORDS, 32, appmer);//***********Para poder colocar textura a las primitivas
    mer.setUserData("Mercurio");
    Sphere venu = new Sphere(0.025f, Primitive.GENERATE_NORMALS |
    Primitive.GENERATE_TEXTURE_COORDS, 32, appvenu);//pasamos radio,flags,divisiones y textura
    venu.setUserData("Venus");
    Sphere earth = new Sphere(0.045f, Primitive.GENERATE_NORMALS |      
    Primitive.GENERATE_TEXTURE_COORDS, 32, appearth);
    earth.setUserData("Tierra");
    Sphere luna = new Sphere(0.019f, Primitive.GENERATE_NORMALS |       
    Primitive.GENERATE_TEXTURE_COORDS, 32, appluna);   
    luna.setUserData("Luna");
    Sphere marte = new Sphere(0.045f, Primitive.GENERATE_NORMALS |      
    Primitive.GENERATE_TEXTURE_COORDS, 32, appmarte);
    marte.setUserData("Marte");
    Sphere jupi = new Sphere(0.060f, Primitive.GENERATE_NORMALS | 
    Primitive.GENERATE_TEXTURE_COORDS, 32, appjupi);
    jupi.setUserData("Jupiter");
    Sphere sat = new Sphere(0.030f, Primitive.GENERATE_NORMALS | 
    Primitive.GENERATE_TEXTURE_COORDS, 32, appsat);
    sat.setUserData("Saturno");
    Sphere uran = new Sphere(0.030f, Primitive.GENERATE_NORMALS | 
    Primitive.GENERATE_TEXTURE_COORDS, 32, appuran);
    uran.setUserData("Urano");
    Sphere nep = new Sphere(0.030f, Primitive.GENERATE_NORMALS | 
    Primitive.GENERATE_TEXTURE_COORDS, 32, appnep);
    nep.setUserData("Neptuno");
    Sphere plu = new Sphere(0.020f, Primitive.GENERATE_NORMALS | 
    Primitive.GENERATE_TEXTURE_COORDS, 32, appplu);
    plu.setUserData("Pluton");
    Cylinder cylinder= new Cylinder(0.08f, 0.005f, primflags, app );
 
    
    //*******************************ROTANDO***********************************************+
	
	solRotX = Posi.rotate(sol, new Alpha(-1,3000));
    merRotX=Posi.rotate(mer,new Alpha(-1,3000));
    venuRotX=Posi.rotate(venu,new Alpha(-1,3000));
    earthRotX = Posi.rotate(earth, new Alpha(-1,3000));
    lunaRotX = Posi.rotate(luna, new Alpha(-1,3000));
    marteRotX = Posi.rotate(marte, new Alpha(-1,3000));
    jupiRotX = Posi.rotate(jupi, new Alpha(-1,3000));
    satRotX = Posi.rotate(sat, new Alpha(-1,3000));
    anilloRotX=Posi.rotate(cylinder,new Alpha(-1,3000));
    uranRotX = Posi.rotate(uran, new Alpha(-1,3000));
    nepRotX = Posi.rotate(nep, new Alpha(-1,3000));
    pluRotX = Posi.rotate(plu, new Alpha(-1,3000));
    
    //********************************TRANSLADANDO*********************************************

	merTransX=Posi.translate(merRotX,new Vector3f(0.0f, 0.0f, -0.20f));
    venuTransX=Posi.translate(venuRotX,new Vector3f(0.0f, 0.0f, 0.30f));
    earthTransX = Posi.translate(earthRotX, new Vector3f(-0.6f, 0.0f, 0.40f));
    lunaTransX = Posi.translate(lunaRotX, new Vector3f(0.0f, 0.0f, 0.1f));
    marteTransX = Posi.translate(marteRotX,new Vector3f(0.30f, 0.0f, 0.50f));
    jupiTransX = Posi.translate(jupiRotX,new Vector3f(0.0f, 0.0f, -0.70f));
    satTransX = Posi.translate(satRotX,new Vector3f(-0.50f, 0.0f, 0.80f));
    uranTransX = Posi.translate(uranRotX,new Vector3f(0.0f, 0.0f, 0.90f));
    nepTransX = Posi.translate(nepRotX,new Vector3f(-0.60f, 0.0f, 0.90f));
    pluTransX = Posi.translate(pluRotX,new Vector3f(-0.80f, 0.0f, -0.90f));
    

    //******************************ROTANDO Y TRASLADANDO AL REDEROR DEL SOL********************

    group.addChild(solRotX);//El sol solo rota
    TransformGroup merRotXGroupX = Posi.rotate(merTransX, new Alpha(-1, 50000));
    group.addChild(merRotXGroupX);//mercurio rotando y trasladando
    TransformGroup venuRotXGroupX=Posi.rotate(venuTransX, new Alpha(-1, 50000));
    group.addChild(venuRotXGroupX);

    TransformGroup earthRotGroupX = Posi.rotate(earthTransX, new Alpha(-1, 50000));
    group.addChild(earthRotGroupX);//tierra rotando y trasladando
    TransformGroup lunaRotGroupX = Posi.rotate(lunaTransX, new Alpha(-1, 5000));
    earthTransX.addChild(lunaRotGroupX);//luna rotando y trasladando pero alrededore de la tierra

    TransformGroup marteRotGroupX = Posi.rotate(marteTransX, new Alpha(-1,50000));
    group.addChild(marteRotGroupX);//marte rotando y transaldando
    TransformGroup jupiRotGroupX = Posi.rotate(jupiTransX, new Alpha(-1, 50000));
    group.addChild(jupiRotGroupX);

    TransformGroup satRotGroupX = Posi.rotate(satTransX, new Alpha(-1, 50000));
    group.addChild(satRotGroupX);
    TransformGroup anilloRotGroupX = Posi.rotate(anilloRotX, new Alpha(-1, 5000));
    satTransX.addChild(anilloRotGroupX);

    TransformGroup uranRotGroupX = Posi.rotate(uranTransX, new Alpha(-1, 50000));
    group.addChild(uranRotGroupX);    
    TransformGroup nepRotGroupX = Posi.rotate(nepTransX, new Alpha(-1, 50000));
    group.addChild(nepRotGroupX);
    TransformGroup pluRotGroupX = Posi.rotate(pluTransX, new Alpha(-1, 50000));
    group.addChild(pluRotGroupX);

    //************************CONFIGURACION GRAFICA*************************************************
            
    	GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
    	Canvas3D canvas = new Canvas3D(config); canvas.setSize(600,250);
    	universe = new SimpleUniverse(canvas);
    	universe.getViewingPlatform().setNominalViewingTransform();
        group.addChild(TuxEscenario(universe));
    	
        //*********************************PERMISOS DE MOVIMIENTO **********************************************

	    solRotX.setCapability(Group.ALLOW_LOCAL_TO_VWORLD_READ);
        solRotX.setCapability(Group.ALLOW_CHILDREN_EXTEND);
        solRotX.setCapability(Group.ALLOW_CHILDREN_WRITE);
        solRotX.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        earthRotX.setCapability(Group.ALLOW_LOCAL_TO_VWORLD_READ);
        earthRotX.setCapability(Group.ALLOW_CHILDREN_EXTEND);
        earthRotX.setCapability(Group.ALLOW_CHILDREN_WRITE);
        earthRotX.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        lunaRotX.setCapability(Group.ALLOW_LOCAL_TO_VWORLD_READ);
        lunaRotX.setCapability(Group.ALLOW_CHILDREN_EXTEND);
        lunaRotX.setCapability(Group.ALLOW_CHILDREN_WRITE);
        lunaRotX.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        marteRotX.setCapability(Group.ALLOW_LOCAL_TO_VWORLD_READ);
        marteRotX.setCapability(Group.ALLOW_CHILDREN_EXTEND);
        marteRotX.setCapability(Group.ALLOW_CHILDREN_WRITE);
        marteRotX.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        merRotX.setCapability(Group.ALLOW_LOCAL_TO_VWORLD_READ);
        merRotX.setCapability(Group.ALLOW_CHILDREN_EXTEND);
        merRotX.setCapability(Group.ALLOW_CHILDREN_WRITE);
        merRotX.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        venuRotX.setCapability(Group.ALLOW_LOCAL_TO_VWORLD_READ);
        venuRotX.setCapability(Group.ALLOW_CHILDREN_EXTEND);
        venuRotX.setCapability(Group.ALLOW_CHILDREN_WRITE);
        venuRotX.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        jupiRotX.setCapability(Group.ALLOW_LOCAL_TO_VWORLD_READ);
        jupiRotX.setCapability(Group.ALLOW_CHILDREN_EXTEND);
        jupiRotX.setCapability(Group.ALLOW_CHILDREN_WRITE);
        jupiRotX.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);


        satRotX.setCapability(Group.ALLOW_LOCAL_TO_VWORLD_READ);
        satRotX.setCapability(Group.ALLOW_CHILDREN_EXTEND);
        satRotX.setCapability(Group.ALLOW_CHILDREN_WRITE);
        satRotX.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        uranRotX.setCapability(Group.ALLOW_LOCAL_TO_VWORLD_READ);
        uranRotX.setCapability(Group.ALLOW_CHILDREN_EXTEND);
        uranRotX.setCapability(Group.ALLOW_CHILDREN_WRITE);
        uranRotX.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        nepRotX.setCapability(Group.ALLOW_LOCAL_TO_VWORLD_READ);
        nepRotX.setCapability(Group.ALLOW_CHILDREN_EXTEND);
        nepRotX.setCapability(Group.ALLOW_CHILDREN_WRITE);
        nepRotX.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        pluRotX.setCapability(Group.ALLOW_LOCAL_TO_VWORLD_READ);
        pluRotX.setCapability(Group.ALLOW_CHILDREN_EXTEND);
        pluRotX.setCapability(Group.ALLOW_CHILDREN_WRITE);
        pluRotX.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);




        //******************CAMARA*******************************************************************
        
        vp = universe.getViewingPlatform();//ViewingPlatform es la localizacion del observador vp es tipo ViewingPlatform
        viewTG = vp.getViewPlatformTransform(); //el metodo regresa el TG del observador (localizacion) y la guardamos

        // DISEÑO....................................

        universe.addBranchGraph(group); 
    	f = new JFrame("Planetario BY SaldañaAguilarGabriela 2CM6 POO");
        JPanel jp1=new JPanel();
    	f.setLayout(new BorderLayout());
    	Vector nomPlanet=new Vector();//array con los nombres de los planetas
    	nomPlanet.addElement("Sol");
    	nomPlanet.addElement("Mercurio");
        nomPlanet.addElement("Venus");
        nomPlanet.addElement("Tierra");
    	nomPlanet.addElement("Marte");
        nomPlanet.addElement("Jupiter");
        nomPlanet.addElement("Saturno");
        nomPlanet.addElement("Urano");
        nomPlanet.addElement("Neptuno");
        nomPlanet.addElement("Pluton");
        jt = new JEditorPane();
        panel2 =new JPanel();//para deslegar la imagen
        //jt.setBounds(0,0,600,300);//X,Y,H,W
        //jt.setEditable(false);//EditorPane para el html
        //jt.addHyperlinkListener(new MicroBrowser(jt));
        pane = new JScrollPane();
        btn= new Button("PLAY");
        btn.addActionListener(new EventHandler());
        jp1.add(btn);
        pane.getViewport().add(panel2);//agregamos el scroll al editorpane
        jcb=new JComboBox(nomPlanet);//agregamos al combobox los planetas de la lista
    	jcb.addActionListener(new EventHandler());
    	jp1.add(jcb);//agregamos el combobox al panel
    	f.add("East",canvas);//agregamos el canvas al frame
    	f.add("South", jp1);//agregamos el panel al frame
        f.add("West", pane);
        //f.add("West", panel2);
        f.setSize(900,700);
       // f.setResizable(false);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
        f.pack(); f.setVisible(true);

        //PARA EL MUESE.......................... 
    	pickCanvas = new PickCanvas(canvas, group);//le pasamos el Branch
    	pickCanvas.setMode(PickCanvas.BOUNDS);
    	canvas.addMouseListener(this);

}//fin constructor

//***********************************MAIN*************************

public static void main(String a[]) { new SolarSis();}

//********************************METODOS*****************************

public void mouseClicked(MouseEvent e){
    pickCanvas.setShapeLocation(e);//trae la poscicon del click
    PickResult result = pickCanvas.pickClosest();//guardamos el objeto seleccionado
    if (result == null) {
       System.out.println("Nothing picked");
    } else {
       Primitive p = (Primitive)result.getNode(PickResult.PRIMITIVE);//obtenemos el planeta
       Shape3D s = (Shape3D)result.getNode(PickResult.SHAPE3D);//para el TextArea
       if (p != null) {
            System.out.println( "UserData1: " + p.getUserData() );//trae la info referente a el objeto seleccionado
            System.out.println(p.getClass().getName()); 

            viewVector = new Vector3f(.0f,.0f, .80f);//para mover la camara sbre el eje z
            viewTransform.setTranslation(viewVector);//agregamos el vector
	        viewTG.setTransform(viewTransform);//lo agregas al grupo
            vp.detach();//separa la camara de donde este

            if(p.getUserData().equals("Sol")){
        	    solRotX.addChild(vp);
                image = new ImageIcon("Solinf.png");
                     label= new JLabel (image);
                     panel2.removeAll();
                     panel2.add(label);
                     System.out.println("INFOSOL");

                //try{

                     //jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/sun-article.html"));

                
                //}catch(IOException ex){
                  //  System.out.println("URL no valido");
                //}

                } 
            if(p.getUserData().equals("Mercurio")){
                merRotX.addChild(vp);

                 //try{

                   // jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/mercury-article.html"));
                    image = new ImageIcon("mercurioinf.png");
                     label= new JLabel (image);
                     panel2.removeAll();
                     panel2.add(label);
                     System.out.println("INFOMERCURIO");
                //}catch(IOException ex){
                  //  System.out.println("URL no valido");
                //}

            }
            if(p.getUserData().equals("Venus")){
                venuRotX.addChild(vp);

               // try{
                 //   jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/venus-article.html"));
                     image = new ImageIcon("venusinf.png");
                     label= new JLabel (image);
                     panel2.removeAll();
                     panel2.add(label);
                     System.out.println("INFOVENUS");

                //}catch(IOException ex){
                  //  System.out.println("URL no valido");
                //}

            }
	        if(p.getUserData().equals("Tierra")){
        	    earthRotX.addChild(vp);

               // try{
                 //   jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/earth.html"));
                     image = new ImageIcon("tierrainf.png");
                     label= new JLabel (image);
                     panel2.removeAll();
                     panel2.add(label);
                     System.out.println("INFOTIERRA");
                //}catch(IOException ex){
                  //  System.out.println("URL no valido");
                //}

            }
            if(p.getUserData().equals("Marte")){
                marteRotX.addChild(vp);
            
               //try{
                 //   jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/mars-article.html"));
                image = new ImageIcon("marteinf.png");
                     label= new JLabel (image);
                     panel2.removeAll();
                     panel2.add(label);
                     System.out.println("INFOMARTE");
                //}catch(IOException ex){
                  //  System.out.println("URL no valido");
                //}  

            }
            if(p.getUserData().equals("Jupiter")){
                jupiRotX.addChild(vp);

                //try{
                  //  jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/jupiter-article.html"));
                image = new ImageIcon("jupiterinf.png");
                     label= new JLabel (image);
                     panel2.removeAll();
                     panel2.add(label);
                     System.out.println("INFOJUPITER");
                //}catch(IOException ex){
                  //  System.out.println("URL no valido");
                //}                

            }
            if(p.getUserData().equals("Saturno")){
                satRotX.addChild(vp);

              // try{
                //    jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/saturn-article.html"));
               image = new ImageIcon("saturnoinf.png");
                     label= new JLabel (image);
                     panel2.removeAll();
                     panel2.add(label);
                     System.out.println("INFOSATURNO");
                //}catch(IOException ex){
                  //  System.out.println("URL no valido");
                //}   

            }
            if(p.getUserData().equals("Urano")){
                uranRotX.addChild(vp);

              // try{
                  //  jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/uranus-article.html"));
                image = new ImageIcon("uranoinf.png");
                     label= new JLabel (image);
                     panel2.removeAll();
                     panel2.add(label);
                     System.out.println("INFOURANO");
                //}catch(IOException ex){
                  //  System.out.println("URL no valido");
                //}   

            }
            if(p.getUserData().equals("Neptuno")){
                nepRotX.addChild(vp);

                //try{
                  //  jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/neptune-article.html"));
                image = new ImageIcon("neptunoinf.png");
                     label= new JLabel (image);
                     panel2.removeAll();
                     panel2.add(label);
                     System.out.println("INFONEPTUNO");
                //}catch(IOException ex){
                  //  System.out.println("URL no valido");
                //} 

            }
            if(p.getUserData().equals("Pluton")){
                pluRotX.addChild(vp);
                
           // try{
             //       jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/dwarf-planet.html"));
               image = new ImageIcon("plutoninf.png");
                     label= new JLabel (image);
                     panel2.removeAll();
                     panel2.add(label);
                     System.out.println("INFOPLUTON");
               // }catch(IOException ex){
                 //   System.out.println("URL no valido");
                //}
                
            }

        } else if (s != null) {
             System.out.println( "UserData2: "+s.getUserData() );
             System.out.println(s.getClass().getName());
        } else{
             System.out.println("null");
        }
    }

}
class EventHandler implements ActionListener {  
    public void actionPerformed(ActionEvent e){
        String nombre=(String)jcb.getSelectedItem();
    
        viewVector = new Vector3f(.0f,.0f, 1.5f);//creamos un nuevo vector que esta sobre el eje z
        viewTransform.setTranslation(viewVector); //al viewtransform le pasamos el lugar(vector)  
        viewTG.setTransform(viewTransform);//TG que contiene el viewingPlatform(localizacion del observador), le pasamos un nuevo lugar
        vp.detach();//separamos 

        if(nombre.equals("Sol")){	
        	solRotX.addChild(vp);

            image = new ImageIcon("solinf.png");
                     label= new JLabel (image);
                     panel2.removeAll();
                     panel2.add(label);
                     System.out.println("INFOSOL");

           // try{
             //   jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/sun-article.html"));
                     
            if(btn==e.getSource()){
                try{
                    File fichero= new File("C://Users//Gabriela//Documents//Escuela//POO//actualiza1//practicas_codigo//practica5//SolarButton1//carrera.avi");
                    URL url= null;
                    url= fichero.toURI().toURL();
                    reproductor video =new reproductor(url);
                    video.setSize(600,465);
                    video.setVisible(true); 
                }catch(MalformedURLException ex){
                    System.out.println("error en cargar el video");
                }
            }//fin if

               // }catch(IOException ex){
                 //   System.out.println("URL no valido");
                //}

        }
        if(nombre.equals("Mercurio")){

            merRotX.addChild(vp);
            image = new ImageIcon("mercurioinf.png");
                     label= new JLabel (image);
                     panel2.removeAll();
                     panel2.add(label);
                     System.out.println("INFOMERCURIO");

            //try{
              //      jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/mercury-article.html"));
                
            if(btn==e.getSource()){
                try{
                    File fichero= new File("C://Users//Gabriela//Documents//Escuela//POO//actualiza1//practicas_codigo//practica5//SolarButton1//carrera.avi");
                    URL url= null;
                    url= fichero.toURI().toURL();
                    reproductor video =new reproductor(url);
                    video.setSize(600,465);
                    video.setVisible(true); 
                }catch(MalformedURLException ex){
                    System.out.println("error en cargar el video");
                }
            }//fin if

                //}catch(IOException ex){
                  //  System.out.println("URL no valido");
                //}

        }
        if(nombre.equals("Venus")){    
            venuRotX.addChild(vp); 
            image = new ImageIcon("venusinf.png");
            panel2.removeAll();
            label= new JLabel (image);
            panel2.add(label);
            System.out.println("INFOVENUS");

             //try{
               //     jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/venus-article.html"));
            if(btn==e.getSource()){
                try{
                    File fichero= new File("C://Users//Gabriela//Documents//Escuela//POO//actualiza1//practicas_codigo//practica5//SolarButton1//carrera.avi");
                    URL url= null;
                    url= fichero.toURI().toURL();
                    reproductor video =new reproductor(url);
                    video.setSize(600,465);
                    video.setVisible(true); 
                }catch(MalformedURLException ex){
                    System.out.println("error en cargar el video");
                }
            }//fin if

                //}catch(IOException ex){
                  //  System.out.println("URL no valido");
                //}

        }        
	   if(nombre.equals("Tierra")){
        	earthRotX.addChild(vp);
             image = new ImageIcon("tierrainf.png");
                    panel2.removeAll();
                     label= new JLabel (image);
                     panel2.add(label);
                     System.out.println("INFOTIERRA");
            //try{
              //      jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/earth.html"));
              
            if(btn==e.getSource()){
                try{
                    File fichero= new File("C://Users//Gabriela//Documents//Escuela//POO//actualiza1//practicas_codigo//practica5//SolarButton1//carrera.avi");
                    URL url= null;
                    url= fichero.toURI().toURL();
                    reproductor video =new reproductor(url);
                    video.setSize(600,465);
                    video.setVisible(true); 
                }catch(MalformedURLException ex){
                    System.out.println("error en cargar el video");
                }

               // }catch(IOException ex){
                 //   System.out.println("URL no valido");
            }

        }
         if(nombre.equals("Marte")){   
            marteRotX.addChild(vp);
             image = new ImageIcon("marteinf.png");
                    panel2.removeAll();
                     label= new JLabel (image);
                     panel2.add(label);
                     System.out.println("INFOMARTE");

            // try{
                   // jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/mars-article.html"));
                
                if(btn==e.getSource()){
                    try{
                        File fichero= new File("C://Users//Gabriela//Documents//Escuela//POO//actualiza1//practicas_codigo//practica5//SolarButton1//carrera.avi");
                        URL url= null;
                        url= fichero.toURI().toURL();
                        reproductor video =new reproductor(url);
                        video.setSize(600,465);
                        video.setVisible(true); 
                        }catch(MalformedURLException ex){
                            System.out.println("error en cargar el video");
                        }
                    }//fin if
                //}catch(IOException ex){
                  //  System.out.println("URL no valido");
                //} 

        }
        if(nombre.equals("Jupiter")){   
            jupiRotX.addChild(vp);
             image = new ImageIcon("jupiterinf.png");
             panel2.removeAll();
                     label= new JLabel (image);
                     panel2.add(label);
                     System.out.println("INFOJUPITER");

            // try{
              //      jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/jupiter-article.html"));
                
                if(btn==e.getSource()){
                    try{
                        File fichero= new File("C://Users//Gabriela//Documents//Escuela//POO//actualiza1//practicas_codigo//practica5//SolarButton1//carrera.avi");
                        URL url= null;
                        url= fichero.toURI().toURL();
                        reproductor video =new reproductor(url);
                        video.setSize(600,465);
                        video.setVisible(true); 
                    }catch(MalformedURLException ex){
                        System.out.println("error en cargar el video");
                    }
                }//fin if/

              //  }catch(IOException ex){
                //    System.out.println("URL no valido");
            //} 

        }
        if(nombre.equals("Saturno")){    
            satRotX.addChild(vp);
             image = new ImageIcon("saturnoinf.png");
             panel2.removeAll();
                     label= new JLabel (image);
                     panel2.add(label);
                     System.out.println("INFOSATURNO");
             // try{
                    //jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/saturn-article.html"));
                
                if(btn==e.getSource()){
                    try{
                        File fichero= new File("C://Users//Gabriela//Documents//Escuela//POO//actualiza1//practicas_codigo//practica5//SolarButton1//carrera.avi");
                        URL url= null;
                        url= fichero.toURI().toURL();
                        reproductor video =new reproductor(url);
                        video.setSize(600,465);
                        video.setVisible(true); 
                    }catch(MalformedURLException ex){
                        System.out.println("error en cargar el video");
                    }
            }//fin if

               // }catch(IOException ex){
                 //   System.out.println("URL no valido");
                //} 

        }
        if(nombre.equals("Urano")){   
            uranRotX.addChild(vp);
             image = new ImageIcon("uranoinf.png");
             panel2.removeAll();
                     label= new JLabel (image);
                     panel2.add(label);
                     System.out.println("INFOURANO");

          //  try{
            //        jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/uranus-article.html"));
               
                if(btn==e.getSource()){
                    try{
                        File fichero= new File("C://Users//Gabriela//Documents//Escuela//POO//actualiza1//practicas_codigo//practica5//SolarButton1//carrera.avi");
                        URL url= null;
                        url= fichero.toURI().toURL();
                        reproductor video =new reproductor(url);
                        video.setSize(600,465);
                        video.setVisible(true); 
                    }catch(MalformedURLException ex){
                        System.out.println("error en cargar el video");
                    }
            }//fin if

              //  }catch(IOException ex){
                //    System.out.println("URL no valido");
                //} 
        }
        if(nombre.equals("Neptuno")){   
            nepRotX.addChild(vp);
             image = new ImageIcon("neptunoinf.png");
             panel2.removeAll();
                     label= new JLabel (image);
                     panel2.add(label);
                     System.out.println("INFONEPTUNO");
             //try{
               //     jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/neptune-article.html"));
                
                   if(btn==e.getSource()){
                    try{
                        File fichero= new File("C://Users//Gabriela//Documents//Escuela//POO//actualiza1//practicas_codigo//practica5//SolarButton1//carrera.avi");
                        URL url= null;
                        url= fichero.toURI().toURL();
                        reproductor video =new reproductor(url);
                        video.setSize(600,465);
                        video.setVisible(true); 
                    }catch(MalformedURLException ex){
                        System.out.println("error en cargar el video");
                    }
            }//fin if

                //}catch(IOException ex){
                  //  System.out.println("URL no valido");
                //} 

        }
        if(nombre.equals("Pluton")){    
            pluRotX.addChild(vp);
             image = new ImageIcon("plutoninf.png");
             panel2.removeAll();
                     label= new JLabel (image);
                     panel2.add(label);
                     System.out.println("INFOPLUTON");
        
            //try{
              //      jt.setPage (new URL("http://science.nationalgeographic.com/science/space/solar-system/dwarf-planet.html"));
                
               if(btn==e.getSource()){
                    try{
                        File fichero= new File("C://Users//Gabriela//Documents//Escuela//POO//actualiza1//practicas_codigo//practica5//SolarButton1//carrera.avi");
                        URL url= null;
                        url= fichero.toURI().toURL();
                        reproductor video =new reproductor(url);
                        video.setSize(600,465);
                        video.setVisible(true); 
                    }catch(MalformedURLException ex){
                        System.out.println("error en cargar el video");
                    }
            }//fin if

              //  }catch(IOException ex){
                //    System.out.println("URL no valido");
                //}   
        }

        //try {
          	//jt.setPage ("http://localhost:8080/"+nombre+".html");
        //} catch (IOException ex) { System.out.println("URL no valido");}
    }//fin action performed
}


//***************************TEXTURA PARA EL UNIVERSO***********************************+

public TransformGroup TuxEscenario(SimpleUniverse simpleU){

//CONTENEDOR

    TransformGroup Tuxcontent = new TransformGroup();
    TransformGroup Tuxtrans=new TransformGroup();
    Tuxcontent.addChild(Tuxtrans);

//ILUMINACION
    BoundingSphere bounds = new BoundingSphere();
    DirectionalLight lightD = new DirectionalLight();
    lightD.setDirection(new Vector3f(0.0f,-0.7f,-0.7f));
    lightD.setInfluencingBounds(bounds);
    Tuxcontent.addChild(lightD);
    AmbientLight lightA = new AmbientLight();
    lightA.setInfluencingBounds(bounds);
    Tuxcontent.addChild(lightA);

//FONDO imagen
    TextureLoader tex = new TextureLoader("ESPACIO.JPG", null);
    ImageComponent2D imagen= tex.getImage();
    Background background = new Background();
    background.setImage(imagen);
    background.setApplicationBounds(bounds);
    Tuxcontent.addChild(background);
    return Tuxcontent;
}


}                                                                         
