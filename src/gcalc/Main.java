package gcalc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Main 
{

	private JFrame frame;
	private JTextField txtQuantity;
	private JTextField txtLength;
	private JTextField txtWeight;
	private JTextField txtCopperWeight;
	private JTextField txtCopperPrice;
	private JTextField txtPVCPrice;
	private JTextField txtProfitPercent;
	private JLabel txtRatePer100Yards;
	private JLabel txtOverallRate;
	private int screenHeight;
	private int screenWidth;
	private JLabel lblSteelWeight;
	private JLabel lblSteelPrice; 
	private gcalc.HintTextField txtSteelWeight;
	private gcalc.HintTextField txtSteelPrice;
	private JButton btnEnter;
	private JButton btnReset;
	private double noOfBundles,rate_per_bundle,weight,proPer,overallRate,pvcWeightPerYards,labourPrice,weightPerBundle,grossRate,length;
	private double steel_weight_per_100Y;
    private double quantity,cuPrice,PVCPrice,steelPrice;
    private Float cu_weight_per_100Y;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenHeight = screenSize.height;
		screenWidth = screenSize.width;
		frame = new JFrame();
		frame.setBounds(0, 0,screenWidth,screenHeight-35);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblQuantity = new JLabel("Quantity             :");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantity.setBounds(27, 91, 137, 26);
		frame.getContentPane().add(lblQuantity);
		
		txtQuantity = new HintTextField("Quantity");
		txtQuantity.setBounds(225, 91, 152, 26);
		frame.getContentPane().add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JLabel lblLength = new JLabel("Length                :");
		lblLength.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLength.setBounds(27, 148, 137, 26);
		frame.getContentPane().add(lblLength);
		
		txtLength = new HintTextField("Length (Yards)");
		txtLength.setColumns(10);
		txtLength.setBounds(225, 148, 152, 26);
		frame.getContentPane().add(txtLength);
		
		JLabel lblWeight = new JLabel("Weight               :");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWeight.setBounds(27, 205, 137, 26);
		frame.getContentPane().add(lblWeight);
		
		JLabel lblCopperWeight = new JLabel("Copper Weight  :");
		lblCopperWeight.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCopperWeight.setBounds(27, 262, 137, 26);
		frame.getContentPane().add(lblCopperWeight);
		
		JLabel lblCopperPrice = new JLabel("Copper Price     :");
		lblCopperPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCopperPrice.setBounds(27, 319, 137, 26);
		frame.getContentPane().add(lblCopperPrice);
		
		JLabel lblPVCPrice = new JLabel("PVC Price          :");
		lblPVCPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPVCPrice.setBounds(27, 376, 137, 26);
		frame.getContentPane().add(lblPVCPrice);
		
		JLabel lblProfitPercent = new JLabel("Profit Percent   : ");
		lblProfitPercent.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProfitPercent.setBounds(27, 433, 137, 26);
		frame.getContentPane().add(lblProfitPercent);
		
		txtWeight = new HintTextField("Weight (Kg)");
		txtWeight.setColumns(10);
		txtWeight.setBounds(225, 205, 152, 26);
		frame.getContentPane().add(txtWeight);
		
		txtCopperWeight = new HintTextField("Kg per 100 yards");
		txtCopperWeight.setColumns(10);
		txtCopperWeight.setBounds(225, 262, 152, 26);
		frame.getContentPane().add(txtCopperWeight);
		
		txtCopperPrice = new HintTextField("Price per Kg (Rs.)");
		txtCopperPrice.setColumns(10);
		txtCopperPrice.setBounds(225, 319, 152, 26);
		frame.getContentPane().add(txtCopperPrice);
		
		txtPVCPrice = new HintTextField("Price per Kg (Rs.)");
		txtPVCPrice.setColumns(10);
		txtPVCPrice.setBounds(225, 376, 152, 26);
		frame.getContentPane().add(txtPVCPrice);
		
		txtProfitPercent = new HintTextField("Percentage");
		txtProfitPercent.setColumns(10);
		txtProfitPercent.setBounds(225, 435, 152, 26);
		frame.getContentPane().add(txtProfitPercent);
		
		JComboBox comboBoxWireSelect = new JComboBox();
		comboBoxWireSelect.setFont(new Font("Arial", Font.BOLD, 13));
		comboBoxWireSelect.setModel(new DefaultComboBoxModel(new String[] {"2 core/ 3 core ( Copper )", "3 core ( Steel )"}));
		comboBoxWireSelect.setBounds(27, 30, 250, 21);
		frame.getContentPane().add(comboBoxWireSelect);
		
		
		JLabel lblNewLabel = new JLabel("Rate per 100 Yards       :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(1009, 91, 175, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblOverall = new JLabel("");
		lblOverall.setBounds(734, 158, 175, 26);
		frame.getContentPane().add(lblOverall);
		
		JLabel lblOverallRate = new JLabel("Overall Rate                   :");
		lblOverallRate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOverallRate.setBounds(1009, 169, 175, 36);
		frame.getContentPane().add(lblOverallRate);
		
		txtRatePer100Yards = new JLabel();
		txtRatePer100Yards.setForeground(new Color(255, 0, 0));
		txtRatePer100Yards.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtRatePer100Yards.setBounds(1243, 91, 196, 36);
		frame.getContentPane().add(txtRatePer100Yards);
	
		txtOverallRate = new JLabel();
		txtOverallRate.setForeground(Color.RED);
		txtOverallRate.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtOverallRate.setBounds(1243, 169, 196, 36);
		frame.getContentPane().add(txtOverallRate);
		
		
		btnEnter = new JButton("Enter");                        // Enter Button
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cu_weight_per_100Y=Float.parseFloat(txtCopperWeight.getText().toString());
				quantity=Double.parseDouble(txtQuantity.getText().toString());
                length=Double.parseDouble(txtLength.getText().toString());
                weight=Double.parseDouble(txtWeight.getText().toString());
                cuPrice=Double.parseDouble(txtCopperPrice.getText().toString());
                PVCPrice=Double.parseDouble(txtPVCPrice.getText().toString());
                
//              System.out.println("Pvc price "+PVCPrice);
                proPer=Double.parseDouble(txtProfitPercent.getText().toString());
                
                noOfBundles=((double)quantity*length)/100;
//              System.out.println("No. oF Bundles:"+noOfBundles);
                
                weightPerBundle=weight/noOfBundles;
//              System.out.println("Weight per bundle"+weightPerBundle);
                
                labourPrice=weightPerBundle*15+10;
//              System.out.println("labour price:"+labourPrice);
                
                if(comboBoxWireSelect.getSelectedItem().toString().equals("2 core/ 3 core ( Copper )"))
				{
	                  
	                pvcWeightPerYards=weightPerBundle-cu_weight_per_100Y;
//	                System.out.println("pvc weight per bundle:"+pvcWeightPerYards);
	                
//	                System.out.println("Gross RAte Itmes:"+cu_weight_per_100Y+","+cuPrice+","+pvcWeightPerYards+","+PVCPrice+","+	labourPrice);
	                
	                grossRate=(cu_weight_per_100Y*cuPrice)+(pvcWeightPerYards*PVCPrice)+labourPrice;
//	                System.out.println("Gross rate:"+grossRate);
	                
	                rate_per_bundle=grossRate*((100+proPer)/100);
	                overallRate=rate_per_bundle*noOfBundles;
	                
	                txtRatePer100Yards.setText(Double.toString(rate_per_bundle));
	                txtRatePer100Yards.setForeground(new Color(255, 0, 0));
//	                System.out.println("Rate +per_undle:"+rate_per_bundle);
	                
	                txtOverallRate.setText(Double.toString(Math.round(overallRate)));
	                txtOverallRate.setForeground(new Color(255,0,0));
//	                System.out.println("Overall rate:"+overallRate);
	                
				}
                else
                {
                	steel_weight_per_100Y=Double.parseDouble(txtSteelWeight.getText().toString());
                	
                	steelPrice=Integer.parseInt(txtSteelPrice.getText());
                	
                	pvcWeightPerYards = weightPerBundle - cu_weight_per_100Y - steel_weight_per_100Y;
                	
                	grossRate=(cu_weight_per_100Y*cuPrice)+(pvcWeightPerYards*PVCPrice)+(steel_weight_per_100Y*steelPrice)+labourPrice;
                	
                	rate_per_bundle=grossRate*((100+proPer)/100);
	                overallRate=rate_per_bundle*noOfBundles;
	                
	                txtRatePer100Yards.setText(Double.toString(rate_per_bundle));
	                txtRatePer100Yards.setForeground(new Color(255, 0, 0));
//	                System.out.println("Rate +per_undle:"+rate_per_bundle);
	                
	                txtOverallRate.setText(Double.toString(Math.round(overallRate)));
	                txtOverallRate.setForeground(new Color(255,0,0));
//	                System.out.println("Overall rate:"+overallRate);
                }
			}
		});
		btnEnter.setBounds(120, 527, 124, 47);
		frame.getContentPane().add(btnEnter);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(919, 71, 550, 179);
		frame.getContentPane().add(panel);
		
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxWireSelect.getSelectedItem().toString().equals("3 core ( Steel )"))
				{
					lblSteelWeight = new JLabel("Steel Weight     : ");
					lblSteelWeight.setFont(new Font("Tahoma", Font.BOLD, 13));
					lblSteelWeight.setBounds(27,376, 136, 26);
					frame.getContentPane().add(lblSteelWeight);
					
					lblSteelPrice = new JLabel("Steel Price        : ");
					lblSteelPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
					lblSteelPrice.setBounds(27, 433, 136, 26);
					frame.getContentPane().add(lblSteelPrice);
					
					txtSteelWeight = new gcalc.HintTextField("Kg per 100 yards");
//					txtSteelWeight.setFont(new Font("Tahoma", Font.BOLD, 13));
					txtSteelWeight.setBounds(225, 376, 152, 26);
					frame.getContentPane().add(txtSteelWeight);
					
					txtSteelPrice = new gcalc.HintTextField("Price per Kg (Rs.)");
//					txtSteelPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
					txtSteelPrice.setBounds(225, 433, 152, 26);
					frame.getContentPane().add(txtSteelPrice);
					
					SwingUtilities.updateComponentTreeUI(frame);   //Refresh the FRame
					
					lblPVCPrice.setBounds(27, 490, 137, 26);  // Changing the position of buttons
					lblProfitPercent.setBounds(27, 547, 137, 26);
					txtPVCPrice.setBounds(225,490, 152, 26);
					txtProfitPercent.setBounds(225, 547, 152, 26);
					btnEnter.setBounds(120, 650, 124, 47);
					btnReset.setBounds(292,650,85,46);
				}
				else {
					frame.getContentPane().remove(lblSteelWeight);
					frame.getContentPane().remove(lblSteelPrice);
					frame.getContentPane().remove(txtSteelPrice);
					frame.getContentPane().remove(txtSteelWeight);
					lblPVCPrice.setBounds(27, 376, 137, 26);
					txtProfitPercent.setBounds(225, 435, 152, 26);
					txtPVCPrice.setBounds(225, 376, 152, 26);
					lblProfitPercent.setBounds(27, 433, 137, 26);
					
					btnEnter.setBounds(120, 527, 124, 47);
					btnReset.setBounds(292, 529, 85, 46);
					
					SwingUtilities.updateComponentTreeUI(frame);  // Refresh The FRame
				}
			}
		});
		btnApply.setBounds(292, 30, 85, 21);
		frame.getContentPane().add(btnApply);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtQuantity.setText("");
				txtLength.setText("");
				txtWeight.setText("");
				txtCopperWeight.setText("");
				txtCopperPrice.setText("");
				txtPVCPrice.setText("");
				txtProfitPercent.setText("");
				txtSteelPrice.setText("");
				txtSteelWeight.setText("");
				
				SwingUtilities.updateComponentTreeUI(frame);  // Refresh The FRame
			}
		});
		btnReset.setBackground(new Color(255, 0, 0));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.setBounds(292, 529, 85, 46);
		frame.getContentPane().add(btnReset);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Settings");
		menuBar.add(mnNewMenu);
		
	}
	    private class SwingAction extends AbstractAction {
		    public SwingAction() {
		    	putValue(NAME, "SwingAction");
		    	putValue(SHORT_DESCRIPTION, "Some short description");
		    }
		    public void actionPerformed(ActionEvent e) {
		    }
	}
}
class HintTextField extends JTextField implements FocusListener {   // Class For hint Text

	  private final String hint;
	  private boolean showingHint;

	  public HintTextField(final String hint) {
	    super(hint);
	    this.hint = hint;
	    this.showingHint = true;
	    super.addFocusListener(this);
	  }

	  @Override
	  public void focusGained(FocusEvent e) {
	    if(this.getText().isEmpty()) {
	      super.setText("");
	      showingHint = false;
	    }
	  }
	  @Override
	  public void focusLost(FocusEvent e) {
	    if(this.getText().isEmpty()) {
	      super.setText(hint);
	      showingHint = true;
	    }
	  }

	  @Override
	  public String getText() {
	    return showingHint ? "" : super.getText();
	  }
}
