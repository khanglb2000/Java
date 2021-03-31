/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0051;

/**
 *
 * @author HI
 */
public class BMIComManager {
    //enum
    private enum statusBMI {
        Under_standard, Standard, Overweight, Fat, Very_Fat;
    }
    
    //fields
    private statusBMI status;
    Validation util = new Validation();
    
    
    //Methods
    public statusBMI checkBMI(double statusBMI) {
        if (statusBMI < 19) {
            return status.Under_standard;
        } else if (statusBMI >= 19 && statusBMI < 25) {
            return status.Standard;
        } else if (statusBMI >= 25 && statusBMI < 30) {
            return status.Overweight; 
        } else if (statusBMI >= 30 && statusBMI < 40) {
            return status.Fat;
        } else {
            return status.Very_Fat;
        }
    }
    
    public void runBMICaculator() {
        int weight = util.getInt("Enter weight(kg): ", "Weight is required [0-200]", "Weight is an int [0-200]", 0, 200);
        int height = util.getInt("Enter height(cm): ", "Height is required [0-300]", "Height is an int [0-300]", 0, 300);
        double BMI = weight * 10000 / (height * height);
        System.out.printf("BMI number: %.2f\n", BMI);
        System.out.println("BMI status: " +checkBMI(BMI));
    }    
}
