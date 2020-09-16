package packageUsage;//package üstüne ctrl+click dersek file olarak nerde olugunu görürürz

import org.w3c.dom.Node;

import java.awt.*;//awt nin içindeki packageları hepsinin classlarına erişim vardır
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.*; //yukardaki 2 importu da kapsar

//import org.graalvm.compiler.graph.Node; ilk Node claasını  nesnesinin kafasın karısır

public class PackageUsage extends Frame// GUI olusturmak içiçn
{
    public PackageUsage(String title) throws HeadlessException {
        super(title);
        setSize(400,400);

        //close the GUI
        addWindowListener(new WindowAdapter()//anonymous class'tır
        {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });


    }


    @Override//Frame classından
    public void paint(Graphics g) {
        super.paint(g);

        Font font=new Font("Sanserif",Font.BOLD,12);
        g.setFont(font);
        g.drawString("JAVA UDEMY COURSE:", 100,100);
    }

    public static void main(String[] args)
    {
        Node node=null;//import org.w3c.dom.Node;

        /*
        sun.tools.tree.Node node2=null;
        sun.jvm.hotspot.opto.Node node3=null;
        jdk.nashorn.internal.ir.Node node4=null;
        org.graalvm.compiler.graph.Node node5=null;

         */
        JUnit.Node node6=null;// ı created this class

        PackageUsage packageUsage=new PackageUsage("Firts GUI");//PENCERE OLUSTU by constructor
        packageUsage.setVisible(true);//make the frame visible

    }

}
