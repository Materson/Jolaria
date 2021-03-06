/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author Materson
 */
import java.lang.Object;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RightBar extends JPanel implements ActionListener{
        private static final int heightPanel = 700, widthPanel = 300;
        private int widthMap, heightMap;
        private JTextField widthField, heightField;
        private JButton createMapButton, nextButton, saveButton, loadButton, closeButton;
        private JTextArea commentArea = new JTextArea(15, 20);
        private JPanel info,nextTurnPanel;
        Graphic window;
        
	public RightBar(Graphic window) {
		setPreferredSize(new Dimension(widthPanel, heightPanel));
                setBackground(Color.gray);
                
                this.window = window;
                setMapSize();
	}

//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//                g.setColor(Color.RED);
//		Graphics2D g2d = (Graphics2D) g;
//                Rectangle2D rectangle = new Rectangle2D.Double(0, 0, widthPanel, heightPanel);
//                g2d.draw(rectangle);
////                JTextField widthField = new JTextField("Szerokosc");
//                    
//	}
        
        protected void setMapSize()
        {
            JLabel widthLabel = new JLabel("Szerokosc: "); 
             widthField = new JTextField();
            JLabel heightLabel = new JLabel("Wysokosc: "); 
             heightField = new JTextField();

            JPanel sizePanel = new JPanel();
            sizePanel.setLayout(new GridLayout(2,2));
            sizePanel.add(widthLabel);
            sizePanel.add(widthField);
            sizePanel.add(heightLabel);
            sizePanel.add(heightField);
            add(sizePanel);
            
            createMapButton = new JButton("Utw??rz");
            createMapButton.addActionListener(this);
            add(createMapButton);
        }
        
        public boolean isNumeric(String s) {  
             return s != null && s.matches("[-+]?\\d*\\.?\\d+"); 
        }
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Object source = e.getSource();

            if(source == createMapButton)
            {
                boolean goodData = false;
                if(!"".equals(widthField.getText()))
                {
                    if(isNumeric(widthField.getText()) && Integer.parseInt(widthField.getText()) > 0)
                    {
                        widthMap = Integer.parseInt(widthField.getText());
                    }
                    
                    if(!"".equals(heightField.getText()))
                    {
                        if(isNumeric(heightField.getText()) && Integer.parseInt(heightField.getText()) > 0)
                        {
                            heightMap = Integer.parseInt(heightField.getText());
                            goodData = true;
                        }
                    }
                }
                
                if(goodData)
                {
                    
                    window.getContentPane().removeAll();
                    window.createMap(widthMap,heightMap);
                    informations();
                    window.revalidate();
                }
            }
            else if(source == nextButton)
            {
                window.map.nextTurn(0,0);
            }
            else if(source == closeButton)
            {
                window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
            }
            else if(source == saveButton)
            {
                window.map.save();
            }
            else if(source == loadButton)
            {
                window.map.load();
                remove(nextTurnPanel);   
                widthMap = window.map.getMapWidth();
                heightMap = window.map.getMapHeight();
//                informations();
                window.revalidate();
                
            }
        }
        
        public void informations()
        {
            info = new JPanel();
            info.setPreferredSize(new Dimension(widthPanel, heightPanel));
            info.setBackground(Color.gray);
            window.add(info, BorderLayout.LINE_END);
            
            JLabel widthLabel = new JLabel("Szerokosc: "+widthMap);
            JLabel heightLabel = new JLabel("Wysoko????: "+heightMap);
            JPanel sizeInfo = new JPanel();
            sizeInfo.setLayout(new GridLayout(1,2));
            sizeInfo.add(widthLabel);
            sizeInfo.add(heightLabel);
            info.add(sizeInfo);
            
            nextTurnPanel = new JPanel();
            nextButton = new JButton("Nastepna tura");
            nextButton.addActionListener(this);
            nextTurnPanel.add(nextButton);
            info.add(nextTurnPanel);
            
            JPanel saveLoad = new JPanel();
            saveLoad.setLayout(new GridLayout(1,2));
            saveButton = new JButton("Zapisz");
            loadButton = new JButton("Wczytaj");
            saveButton.addActionListener(this);
            saveButton.addActionListener(this);
            loadButton.addActionListener(this);
            nextTurnPanel.add(saveButton);
            nextTurnPanel.add(loadButton);
            info.add(nextTurnPanel);
            closeButton = new JButton("Zamkinj");
            closeButton.addActionListener(this);
            info.add(closeButton, BorderLayout.PAGE_END);
            
            commentArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(commentArea); 
            info.add(scrollPane);
        }
        
        public void addComment(String com)
        {
            commentArea.append(com+"\n");
        }
        
}