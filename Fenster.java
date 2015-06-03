//TODO:zu UPPERCASE STRINGS,Keyboardlistener
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fenster extends JFrame implements ActionListener
{
    public static Fenster Fenster1;
    public JButton[] buttons;
    public JRadioButton Hex,Dec;
    public JTextField Ergebnis;
    public String cText;
    public String nText;
    public String privString;
    public int addCounter=0;
    public String PasteText;
    public JLabel index; 
    public int subCounter=0;

    public void main()
    {
        Fenster1 = new Fenster();
    }

    public Fenster()
    {
        super("Hex Calc"); //Fenstertitel  
        buttons = new JButton[21];
        Font Arial1 = new Font("Arial", Font.BOLD, 20); //Schriftart für Ausgabe

        setDefaultCloseOperation(EXIT_ON_CLOSE); //X-Button
        getContentPane().setLayout(null);        //Jede Position jedes Buttons kann festgelegt werden
        setResizable(false);         //Fenster kann nicht resized werden
        Ergebnis = new JTextField("Ergebnis");
        Ergebnis.setFont(Arial1);
        Ergebnis.setBounds(170,20,200,40); //Größe von dem Eingabefenster
        add(Ergebnis); //Eingabe wird angezeigt
        //Buttonerstellung
        for(int count=0;count<20;count++){
            if(count<10){
                if(count == 0){
                    buttons[count] = new JButton(Integer.toString(count));
                    buttons[count].setBounds(220,190,30,30);
                    buttons[count].setMargin(new Insets(1,1,1,1));
                    add(buttons[count]);

                }
                else if(count<4){
                    buttons[count] = new JButton(Integer.toString(count));
                    buttons[count].setBounds(180+(count*40)-40,70,30,30);
                    buttons[count].setMargin(new Insets(1,1,1,1));
                    add(buttons[count]);

                }
                else if(count<7){
                    buttons[count] = new JButton(Integer.toString(count));
                    buttons[count].setBounds(180+(count*40)-160,110,30,30);
                    buttons[count].setMargin(new Insets(1,1,1,1));
                    add(buttons[count]);

                }
                else if(count<10){
                    buttons[count] = new JButton(Integer.toString(count));
                    buttons[count].setBounds(180+(count*40)-280,150,30,30);
                    buttons[count].setMargin(new Insets(1,1,1,1));
                    add(buttons[count]);

                }
            }
            else if(count<16)

            {
                if(count == 10){
                    buttons[count] = new JButton("A");
                    buttons[count].setBounds(300,70,30,30);
                    buttons[count].setMargin(new Insets(1,1,1,1));
                    add(buttons[count]);
                }
                else if(count == 11){
                    buttons[count] = new JButton("B");
                    buttons[count].setBounds(300,110,30,30);
                    buttons[count].setMargin(new Insets(1,1,1,1));
                    add(buttons[count]);
                }
                else if(count == 12){
                    buttons[count] = new JButton("C");
                    buttons[count].setBounds(300,150,30,30);
                    buttons[count].setMargin(new Insets(1,1,1,1));
                    add(buttons[count]);
                }
                else if(count == 13){
                    buttons[count] = new JButton("D");
                    buttons[count].setBounds(340,70,30,30);
                    buttons[count].setMargin(new Insets(1,1,1,1));
                    add(buttons[count]);
                }
                else if(count == 14){
                    buttons[count] = new JButton("E");
                    buttons[count].setBounds(340,110,30,30);
                    buttons[count].setMargin(new Insets(1,1,1,1));
                    add(buttons[count]);
                }
                else if(count == 15){
                    buttons[count] = new JButton("F");
                    buttons[count].setBounds(340,150,30,30);
                    buttons[count].setMargin(new Insets(1,1,1,1));
                    add(buttons[count]);
                }
                else
                {  
                    JOptionPane.showMessageDialog(this,"Kritischer Fehler, Button Array out of Bounds");
                }
            }
        }
        buttons[16] =new JButton("=");
        buttons[16].setBounds(380,30,30,30);
        buttons[16].setMargin(new Insets(1,1,1,1));
        add(buttons[16]);
        buttons[17]= new JButton("T");
        buttons[17].setBounds(420,30,30,30);
        buttons[17].setMargin(new Insets(1,1,1,1));
        add(buttons[17]);
        buttons[18]= new JButton("DEL");
        buttons[18].setBounds(380,70,30,30);
        buttons[18].setMargin(new Insets(1,1,1,1));
        add(buttons[18]);
        buttons[19]= new JButton("+");
        buttons[19].setBounds(420,70,30,30);
        buttons[19].setMargin(new Insets(1,1,1,1));
        add(buttons[19]);
        buttons[20]= new JButton("-");
        buttons[20].setBounds(420,110,30,30);
        buttons[20].setMargin(new Insets(1,1,1,1));
        add(buttons[20]);
        //Ende der Buttons

        //RadioButton Für Dec
        Dec = new JRadioButton("Dec", true);
        getContentPane().add(Dec);
        Dec.setLocation(20,0);
        Dec.setBounds(20,0,50,70);

        //RadioButton für Hex
        Hex = new JRadioButton("Hex", false);
        getContentPane().add(Hex);
        Hex.setLocation(80,0);
        Hex.setBounds(80,0,70,70);

        //RadioGroup, sodass nur ein RadioButton angewählt werden kann
        ButtonGroup gruppe = new ButtonGroup();
        gruppe.add(Dec);
        gruppe.add(Hex);

        //Versch. für das Fenster
        setLocation(250, 190);
        setSize(500, 300);
        setVisible(true);

        //Label
        index = new JLabel("D");
        index.setBounds(470,30,30,30);
        add(index);
        index.setText("D");
        //Buttons sind anklickbar
        for(int z=0;z<buttons.length;z++){
            buttons[z].addActionListener(this);
        }

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == buttons[0]){
            privString = Ergebnis.getText();
            if(privString.equals("Ergebnis"))
            {
                Ergebnis.setText("");
            }
            cText=Ergebnis.getText();
            nText=cText+"0";
            Ergebnis.setText(nText);
        }
        if(ae.getSource() ==buttons[1]){
            privString = Ergebnis.getText();
            if(privString.equals("Ergebnis"))
            {
                Ergebnis.setText("");
            }
            cText=Ergebnis.getText();
            nText=cText+"1";
            Ergebnis.setText(nText);
        }
        if(ae.getSource() ==buttons[2]){
            privString = Ergebnis.getText();
            if(privString.equals("Ergebnis"))
            {
                Ergebnis.setText("");
            }
            cText=Ergebnis.getText();
            nText=cText+"2";
            Ergebnis.setText(nText);
        }
        if(ae.getSource() ==buttons[3]){
            privString = Ergebnis.getText();
            if(privString.equals("Ergebnis"))
            {
                Ergebnis.setText("");
            }
            cText=Ergebnis.getText();
            nText=cText+"3";
            Ergebnis.setText(nText);
        }
        if(ae.getSource() ==buttons[4]){
            privString = Ergebnis.getText();
            if(privString.equals("Ergebnis"))
            {
                Ergebnis.setText("");
            }
            cText=Ergebnis.getText();
            nText=cText+"4";
            Ergebnis.setText(nText);
        }
        if(ae.getSource() ==buttons[5]){
            privString = Ergebnis.getText();
            if(privString.equals("Ergebnis"))
            {
                Ergebnis.setText("");
            }
            cText=Ergebnis.getText();
            nText=cText+"5";
            Ergebnis.setText(nText);
        }
        if(ae.getSource() ==buttons[6]){
            privString = Ergebnis.getText();
            if(privString.equals("Ergebnis"))
            {
                Ergebnis.setText("");
            }
            cText=Ergebnis.getText();
            nText=cText+"6";
            Ergebnis.setText(nText);
        }
        if(ae.getSource() ==buttons[7]){
            privString = Ergebnis.getText();
            if(privString.equals("Ergebnis"))
            {
                Ergebnis.setText("");
            }
            cText=Ergebnis.getText();
            nText=cText+"7";
            Ergebnis.setText(nText);
        }
        if(ae.getSource() ==buttons[8]){
            privString = Ergebnis.getText();
            if(privString.equals("Ergebnis"))
            {
                Ergebnis.setText("");
            }
            cText=Ergebnis.getText();
            nText=cText+"8";
            Ergebnis.setText(nText);
        }
        if(ae.getSource() ==buttons[9]){
            privString = Ergebnis.getText();
            if(privString.equals("Ergebnis"))
            {
                Ergebnis.setText("");
            }
            cText=Ergebnis.getText();
            nText=cText+"9";
            Ergebnis.setText(nText);
        }
        if(ae.getSource() ==buttons[10]){
            privString = Ergebnis.getText();
            if(privString.equals("Ergebnis"))
            {
                Ergebnis.setText("");
            }
            cText=Ergebnis.getText();
            nText=cText+"A";
            Ergebnis.setText(nText);
        }
        if(ae.getSource() ==buttons[11]){
            privString = Ergebnis.getText();
            if(privString.equals("Ergebnis"))
            {
                Ergebnis.setText("");
            }
            cText=Ergebnis.getText();
            nText=cText+"B";
            Ergebnis.setText(nText);
        }
        if(ae.getSource() ==buttons[12]){
            privString = Ergebnis.getText();
            if(privString.equals("Ergebnis"))
            {
                Ergebnis.setText("");
            }
            cText=Ergebnis.getText();
            nText=cText+"C";
            Ergebnis.setText(nText);
        }
        if(ae.getSource() ==buttons[13]){
            privString = Ergebnis.getText();
            if(privString.equals("Ergebnis"))
            {
                Ergebnis.setText("");
            }
            cText=Ergebnis.getText();
            nText=cText+"D";
            Ergebnis.setText(nText);
        }
        if(ae.getSource() ==buttons[14]){
            privString = Ergebnis.getText();
            if(privString.equals("Ergebnis"))
            {
                Ergebnis.setText("");
            }
            cText=Ergebnis.getText();
            nText=cText+"E";
            Ergebnis.setText(nText);
        }
        if(ae.getSource() ==buttons[15]){
            privString = Ergebnis.getText();
            if(privString.equals("Ergebnis"))
            {
                Ergebnis.setText("");
            }
            cText=Ergebnis.getText();
            nText=cText+"F";
            Ergebnis.setText(nText);
        }
        if(ae.getSource() ==buttons[16]){
            if(Dec.isSelected() == true){
                if(addCounter==0&&subCounter==0){
                    JOptionPane.showMessageDialog(this,"nicht genügend Angaben");
                }
                if(addCounter>0||subCounter>0){
                    if (addCounter>0){
                        Ergebnis.setText(AddierenDec(PasteText,Ergebnis.getText()));
                        addCounter = 0;
                        index.setText("D");
                    }
                    if(subCounter>0){
                        Ergebnis.setText(SubtrahierenDec(PasteText,Ergebnis.getText()));
                        subCounter = 0;
                        index.setText("D");
                    }
                }
            }
            if(Hex.isSelected() ==true){
                if(addCounter==0&&subCounter==0){
                    JOptionPane.showMessageDialog(this,"nicht genügend Angaben");
                }
                if(addCounter>0||subCounter>0){
                    if (addCounter>0){
                        Ergebnis.setText("0x"+AddierenHex(PasteText,Ergebnis.getText()));
                        addCounter = 0;
                        index.setText("H");
                    }
                    if(subCounter>0){
                        Ergebnis.setText("0x"+SubtrahierenHex(PasteText,Ergebnis.getText()));
                        subCounter = 0;
                        index.setText("H");
                    }
                }
            }
        }
        if(ae.getSource() ==buttons[17]){
            if(Dec.isSelected() == true){
                cText=Ergebnis.getText();
                if(isDec(cText)==true)
                {
                    long PrivateZahl = Long.parseLong(cText);
                    Ergebnis.setText("0x"+ DecInHex(PrivateZahl));
                    index.setText("H");
                }
                else{
                    JOptionPane.showMessageDialog(this,"Keine Dezimalzahl");
                }
            }
            if(Hex.isSelected() ==true){
                String mxt =  Long.toString(HexInDec(Ergebnis.getText()));
                Ergebnis.setText(mxt);
                index.setText("D");
            }
        }
        if(ae.getSource() ==buttons[18]){
            addCounter =0;
            subCounter=0;
            PasteText = "";
            Ergebnis.setText("");
        }
        if(ae.getSource() ==buttons[19]){
            if(addCounter>0){
                if(isDec(Ergebnis.getText())&&!isHex(Ergebnis.getText())&&Dec.isSelected()==true){
                    Ergebnis.setText(AddierenDec(PasteText,Ergebnis.getText()));
                    addCounter=0;
                    index.setText("D");
                }
                if(isHex(Ergebnis.getText())&&Ergebnis.getText().startsWith("0x")||Hex.isSelected()==true){
                    Ergebnis.setText("0x"+AddierenHex(PasteText,Ergebnis.getText()));
                    addCounter = 0;
                    index.setText("H");
                }
                else if(!isHex(Ergebnis.getText())&&Ergebnis.getText().startsWith("0x")&&!isDec(Ergebnis.getText()))
                {
                    JOptionPane.showMessageDialog(this,"Kein richtiger Input");
                }
            }
            if(addCounter == 0){
                PasteText = Ergebnis.getText();
                addCounter++;
                Ergebnis.setText("");
            }
        }
        if(ae.getSource() ==buttons[20]){
            if(subCounter>0){
                if(isDec(Ergebnis.getText())&&!isHex(Ergebnis.getText())&&Dec.isSelected()==true){
                    Ergebnis.setText(SubtrahierenDec(PasteText,Ergebnis.getText()));
                    subCounter=0;
                    index.setText("D");
                }
                if(isHex(Ergebnis.getText())&&Ergebnis.getText().startsWith("0x")||Hex.isSelected()==true){
                    Ergebnis.setText("0x"+SubtrahierenHex(PasteText,Ergebnis.getText()));
                    subCounter = 0;
                    index.setText("H");
                }
                else if(!isHex(Ergebnis.getText())&&Ergebnis.getText().startsWith("0x")&&!isDec(Ergebnis.getText()))
                {
                    JOptionPane.showMessageDialog(this,"Kein richtiger Input");
                }
            }
            if(subCounter == 0){
                PasteText = Ergebnis.getText();
                subCounter++;
                Ergebnis.setText("");
            }
        }
    }

    public String DecInHex(long Param){
        long newParam = Param;
        String Param2 = Long.toString(newParam);
        String Ergebnis = "";
        if(isDec(Param2)){
            while(newParam!=0){
                if ((newParam%16)< 10) 
                {
                    Ergebnis = newParam%16 +Ergebnis;
                }
                if ((newParam%16)==10) 
                {
                    Ergebnis = "A"+Ergebnis;
                }
                if ((newParam%16)==11) 
                {
                    Ergebnis = "B"+Ergebnis;
                }
                if ((newParam%16)==12) 
                {
                    Ergebnis = "C"+Ergebnis;
                }
                if ((newParam%16)==13) 
                {
                    Ergebnis = "D"+Ergebnis;
                }
                if ((newParam%16)==14) 
                {
                    Ergebnis = "E"+Ergebnis;
                }
                if ((newParam%16)==15) 
                {
                    Ergebnis = "F"+Ergebnis;
                }
                newParam =newParam/16;
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"keine Dezimalzahl");
        }
        return Ergebnis;
    }

    public long HexInDec(String Param){
        String PrivateString = Param;
        long x=0;
        if(PrivateString.startsWith("0x")){
            String Priv;
            Priv = PrivateString.substring(2,PrivateString.length());//0x entfernen
            PrivateString = Priv;
        }
        if(isHex(PrivateString) == false){
            JOptionPane.showMessageDialog(this,"Kein hexadezimaler Input");
        }
        else if(isHex(PrivateString) == true){
            int priv = PrivateString.length()-1;
            for(int i=0;i<PrivateString.length();i++)
            {
                if(PrivateString.charAt(i) == '0')
                {
                    x =  x+ (0*((long)Math.pow(16,priv)));
                }
                if(PrivateString.charAt(i) == '1')
                {
                    x =  x+ (1*((long)Math.pow(16,priv)));
                }
                if(PrivateString.charAt(i) == '2')
                {
                    x =  x+ (2*((long)Math.pow(16,priv)));
                }
                if(PrivateString.charAt(i) == '3')
                {
                    x =  x+ (3*((long)Math.pow(16,priv)));
                }
                if(PrivateString.charAt(i) == '4')
                {
                    x =  x+ (4*((long)Math.pow(16,priv)));
                }
                if(PrivateString.charAt(i) == '5')
                {
                    x =  x+ (5*((long)Math.pow(16,priv)));
                }
                if(PrivateString.charAt(i) == '6')
                {
                    x =  x+ (6*((long)Math.pow(16,priv)));
                }
                if(PrivateString.charAt(i) == '7')
                {
                    x =  x+ (7*((long)Math.pow(16,priv)));
                }
                if(PrivateString.charAt(i) == '8')
                {
                    x =  x+ (8*((long)Math.pow(16,priv)));
                }
                if(PrivateString.charAt(i) == '9')
                {
                    x =  x+ (9*((long)Math.pow(16,priv)));
                }
                if(PrivateString.charAt(i) == 'A')
                {
                    x =  x+ (10*((long)Math.pow(16,priv)));
                }
                if(PrivateString.charAt(i) == 'B')
                {
                    x =  x+ (11*((long)Math.pow(16,priv)));
                }
                if(PrivateString.charAt(i) == 'C')
                {
                    x =  x+ (12*((long)Math.pow(16,priv)));
                }
                if(PrivateString.charAt(i) == 'D')
                {
                    x =  x+ (13*((long)Math.pow(16,priv)));
                }
                if(PrivateString.charAt(i) == 'E')
                {
                    x =  x+ (14*((long)Math.pow(16,priv)));
                }
                if(PrivateString.charAt(i) == 'F')
                {
                    x =  x+ (15*((long)Math.pow(16,priv)));
                }
                priv--;
            }
        }
        return x;
    }
    public boolean isHex(String Param){
        boolean bool=true;
        for(int i=0;i<Param.length();i++){
            if(Param.charAt(i) == 'A'||
            Param.charAt(i) == 'B'||
            Param.charAt(i) == 'C'||
            Param.charAt(i) == 'D'||
            Param.charAt(i) == 'E'||
            Param.charAt(i) == 'F'||
            Param.charAt(i) == '0'||
            Param.charAt(i) == '1'||
            Param.charAt(i) == '2'||
            Param.charAt(i) == '3'||
            Param.charAt(i) == '4'||
            Param.charAt(i) == '5'||
            Param.charAt(i) == '6'||
            Param.charAt(i) == '7' ||
            Param.charAt(i) == '8'||
            Param.charAt(i) == '9')
            {
            }
            else
            {
                bool = false;
            }
        }
        return bool;
    }
    public boolean isDec(String Param){
        boolean bool=true;
        for(int i=0;i<Param.length();i++){
            if(
            Param.charAt(i) == '0'||
            Param.charAt(i) == '1'||
            Param.charAt(i) == '2'||
            Param.charAt(i) == '3'||
            Param.charAt(i) == '4'||
            Param.charAt(i) == '5'||
            Param.charAt(i) == '6'||
            Param.charAt(i) == '7' ||
            Param.charAt(i) == '8'||
            Param.charAt(i) == '9')
            {

            }
            else{
                bool=false;
            }
        }
        return bool;
    }
    public String AddierenDec(String input1,String input2){
        long privInput1=Long.parseLong(input1);
        long privInput2=Long.parseLong(input2);
        long privOut1 = privInput1+privInput2;
        String PrivString=Long.toString(privOut1);
        return PrivString;
    }
    public String AddierenHex(String input1,String input2){
        long Priv1=HexInDec(input1);
        long Priv2=HexInDec(input2);
        long PrivLong = Priv1 + Priv2;
        String PrivString2 = DecInHex(PrivLong);
        return PrivString2;
    }
    public String SubtrahierenDec(String input1,String input2){
        long privInput1=Long.parseLong(input1);
        long privInput2=Long.parseLong(input2);
        long privOut1 = privInput1-privInput2;
        String PrivString=Long.toString(privOut1);
        return PrivString;
    }
    public String SubtrahierenHex(String input1,String input2){
        long Priv1=HexInDec(input1);
        long Priv2=HexInDec(input2);
        long PrivLong = Priv1 - Priv2;
        String PrivString2 = DecInHex(PrivLong);
        return PrivString2;
    }
}

