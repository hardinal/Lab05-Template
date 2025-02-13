package apps;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class Calculator
{
    private final int X_LOC = 100;
    private final int Y_LOC = 100;
    private final int WIDTH = 200;
    private final int HEIGHT  = 200;
    private final String NAME = "rotaluclac calculator";
    private final String RESULT_PREAMBLE = "Result = ";
    private final String ERROR_PREAMBLE = "Error";
    private JFrame frame;
    private JTextField leftOpField;
    private JTextField rightOpField;
    private JTextField resultLabel;

    public Calculator()
    {
        createFrame();
        initializeComponents();
        displayFrame();

    }

    public JFrame getFrame()
    {
        return frame;
    }

    private void createFrame()
    {
        frame = new JFrame();
        frame.setLocation(X_LOC, Y_LOC);
        frame.setTitle(NAME);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeComponents()
    {
        initializeInputs();
        initializeButtons();
    }

    private void displayFrame()
    {
        frame.pack();
        frame.setVisible(true);
    }

    private void initializeInputs()
    {
        JPanel inputP = new JPanel(new GridLayout(1, 2, 5, 5));
        leftOpField = new JTextField(5);
        rightOpField = new JTextField(5);
        leftOpField.setName("leftOperand");
        rightOpField.setName("rightOperand");
        inputP.add(leftOpField);
        inputP.add(rightOpField);

        frame.add(inputP, BorderLayout.NORTH);
    }

    private void initializeResults()
    {
        JPanel resultP = new JPanel(new GridLayout(1, 2, 5, 5));
        resultLabel = new JTextField(5);
        resultLabel.setName("resultLabel");
        resultP.add(resultLabel);
        frame.add(resultP, BorderLayout.SOUTH);

    }

    private void initializeButtons()
    {

    }

    private double getLeftNum()
    {

    }

    private double getRightNum()
    {

    }

    private void updateResult(doublke result)
    {

    }

}
