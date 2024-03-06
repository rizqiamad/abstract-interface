package store;

public class Casher extends AbstractStoreEmployee {

  private byte rating;

  public Casher(
    double numberOfHoursWorked,
    double hourlyRate,
    String storeDetails,
    double basePay,
    String casherName,
    byte rating,
    String birthDay,
    byte yearWorking,
    String feelling
  ) {
    super(
      numberOfHoursWorked,
      hourlyRate,
      storeDetails,
      basePay,
      casherName,
      birthDay,
      yearWorking,
      feelling
    );
    this.rating = rating;
  }

  public String getRating(byte rating) {
    if (rating == 1) {
      return "Very Bad🌟";
    } else if (rating == 2) {
      return "Bad🌟🌟";
    } else if (rating == 3) {
      return "Good Enough🌟🌟🌟";
    } else if (rating == 4) {
      return "Good🌟🌟🌟🌟";
    } else {
      return "Very Good🌟🌟🌟🌟🌟";
    }
  }

  /**
   * Returns calculated Pay of the Sales Associate. The calculated pay is the
   * sum of basePay, commission and the product of number of hours worked and
   * hourly rate.
   *
   * @return - This method returns Payment of the Sales Associate.
   */
  @Override
  public double calculatePay() {
    return (
      super.getBasePay() +
      calculateCommission() +
      (super.getNumberOfHoursWorked() * super.getHourlyRate())
    );
  }

  /**
   * Checks if the employee should be awarded with a promotion.
   *
   * @return - This method returns boolean the eligibility status for
   * promotion for an employee.
   */
  @Override
  public boolean checkPromotionEligibility() {
    if (calculatePay() > 25000.0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns the String representation of Sales. Append Super Class toString()
   * along with the Sales Rate.
   *
   * @return - This method returns a String representation of Sales and
   * Employee details.
   */
  @Override
  public String toString() {
    return super.toString() + "Rating: " + getRating(this.rating);
  }

  @Override
  public String birthDay() {
    return super.getBirthDay();
  }

  @Override
  public byte yearWorking() {
    return super.getYearWorking();
  }

  /**
   * Override abstract method from class AbstractStoreEmployee
   */
  @Override
  public String feelling() {
    return super.getFeelling();
  }
}
