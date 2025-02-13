package apps;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *  Java prototype mini calculator. Basic functionality and quite useless...
 *  Unless you need a good grade, or decide to upgrade the functionality.
 *
 *  @author Austin Hardin
 *  @version v1 13FEB25
 *
 * BEHOLD! The CALCULATOR CLASS!
 */
public class Calculator
{

    private static final int X_LOC = 100;

    private static final int Y_LOC = 100;

    private static final int WIDTH = 250;

    private static final int HEIGHT  = 215;

    private static final String NAME = "rotaluclac calculator";

    private static final String RESULT_PREAMBLE = "Result = ";

    private static final String ERROR_MESSAGE = "Error";

    private JFrame frame;

    private JTextField leftOpField;

    private JTextField rightOpField;

    private JTextField resultLabel;

    /**
     * Calculator constructor, calls appropriate methods for
     * creating the calculator.
     */
    public Calculator()
    {
        createFrame();
        initializeComponents();
        displayFrame();

    }

    /**
     * Gets frame.
     *
     * @return the frame
     */
    public JFrame getFrame()
    {
        return frame;
    }


    /**
     * Create frame.
     * Creates a new main frame and gives default settings.
     */
    private void createFrame()
    {
        frame = new JFrame();
        frame.setLocation(X_LOC, Y_LOC);
        frame.setTitle(NAME);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * Helper method.
     */
    private void initializeComponents()
    {
        initializeInputs();
        initializeButtons();
        initializeResults();
    }

    /**
     * Display frame LETS SEE IT.
     */
    private void displayFrame()
    {

        frame.setVisible(true);
    }

    /**
     * Initialize inputs.
     *
     * Sub panel for input fields.
     */
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

    /**
     * Initializes sub panel for results.
     */
    private void initializeResults()
    {
        JPanel resultP = new JPanel(new GridLayout(1, 2, 5, 5));
        resultLabel = new JTextField(5);
        resultLabel.setName("resultLabel");
        resultP.add(resultLabel);
        frame.add(resultP, BorderLayout.SOUTH);

    }

    /**
     * Initializes the buttons.
     *
     * Beep boop beep beep. Just pretend.
     * The buttons are listening so be careful what you say.
     * They may add, subtract, divide, or MULT your words... or input.
     */
    private void initializeButtons()
    {
        JPanel buttonP = new JPanel(new GridLayout(2, 2, 5, 5));

        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton multButton = new JButton("x");
        JButton divButton = new JButton("÷");


        addButton.setName("addButton");
        subButton.setName("subButton");
        multButton.setName("multButton");
        divButton.setName("divButton");
        addButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                double result = getLeftNum() + getRightNum();
                updateResult(result);
            }
        });

        subButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                double result = getLeftNum() - getRightNum();
                updateResult(result);
            }
        });

        multButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                double result = getLeftNum() * getRightNum();
                updateResult(result);
            }
        });

        divButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                double rightNum = getRightNum();

                if (rightNum == 0)
                {
                    updateResult(Double.NaN);
                }
                else
                {
                    double result = getLeftNum() / getRightNum();
                    updateResult(result);
                }
            }
        });

        buttonP.add(addButton);
        buttonP.add(subButton);
        buttonP.add(multButton);
        buttonP.add(divButton);

        frame.add(buttonP, BorderLayout.CENTER);
    }

    /**
     * Gets left number for the mathematical operations to be performed on.
     *
     * @return the left num
     */
    private double getLeftNum()
    {
        try
        {
            String inL = leftOpField.getText();

            if (inL.isEmpty())
            {
                return Double.NaN;
            }
            return Double.parseDouble(inL);
        }
        catch (NumberFormatException e)
        {
            return Double.NaN;
        }
    }

    /**
     * The challenger, RIGHT NUMBEEEEEEER!!!
     *
     * @return the right num
     */
    private double getRightNum()
    {
        try
        {
            String inR = rightOpField.getText();

            if (inR.isEmpty())
            {
                return Double.NaN;
            }
            return Double.parseDouble(inR);
        }
        catch (NumberFormatException e)
        {
            return Double.NaN;
        }
    }

    /**
     * Update result.
     *
     * "Baby, this is what we came for..."
     * STEP RIGHT UP FOLKS AND SEE THE GREAT NUMBER MACHINE!
     * @param result the result
     */
    private void updateResult(double result)
    {
        if (Double.isNaN(result))
        {
            resultLabel.setText(RESULT_PREAMBLE + ERROR_MESSAGE);
        }
        else
        {
            resultLabel.setText(RESULT_PREAMBLE + result);
        }

    }

}
