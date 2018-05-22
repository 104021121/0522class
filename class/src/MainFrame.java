import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private int dirFlag=1,objX=50,objY=50,objW=50,objH=50;
        private JPanel jbc=new JPanel();
        private JPanel jbs=new JPanel(new GridLayout(1,6,3,3));
        private Container cp ;
        private JLabel jlb=new JLabel();
        private ImageIcon icon =new ImageIcon("boat.png");
        private Timer t1 ;
        private  JButton jbtrun = new JButton("Run");

        private JButton jbt []=new JButton[5];
        private  JButton jbt5 = new JButton("Exit");






        public MainFrame(){
            inti();
        }


        private void inti (){
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setLayout(null);
            this.setBounds(500,250,600,600);
            this.setResizable(false);

            cp=this.getContentPane();
            cp.setLayout(new BorderLayout(3,3));
            cp.add(jbc,BorderLayout.CENTER);
            cp.add(jbs,BorderLayout.SOUTH);
            jbs.add(jbtrun);

            for(int i=1 ;i<5;i++){

                jbt[i]=new JButton();
                jbs.add(jbt[i]);
            }

            jbt[1].setText("↑");
            jbt[2].setText("↓");
            jbt[3].setText("←");
            jbt[4].setText("→");


            jbs.add(jbt5);
            jbc.add(jlb);
            jlb.setBounds(objX,objY,50,50);
            jlb.setIcon(icon);


            jbt[1].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dirFlag=1;
                }
            });


            jbt[2].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dirFlag=2;
                }
            });

            jbt[3].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dirFlag=3;
                }
            });

            jbt[4].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dirFlag=4;
                }
            });





            jbtrun.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    t1.start();
                }
            });





            t1=new Timer(200, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (dirFlag){
                        case 1 :
                            if(objY-2>0){
                                objY-=2;
                            }break;
                        case 2 :
                            if(objY+2<250){
                                objY+=2;
                            }break;
                        case 3 :
                            if(objX-2>0){
                                objX-=2;
                            }break;
                        case 4 :
                            if(objX+2<500){
                                objX+=2;
                            }break;
                    }
                    jlb.setLocation(objX,objY);
                }
            });
            jbt5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

    }

}
