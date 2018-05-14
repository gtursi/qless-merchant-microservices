package qless.merchant.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * PhoneNumber
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-09T09:53:33.998-03:00")

public class PhoneNumber   {
  @JsonProperty("countryCode")
  private String countryCode = null;

  @JsonProperty("digits")
  private String digits = null;

  public PhoneNumber countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * The international phone number calling code.
   * @return countryCode
  **/
  @ApiModelProperty(example = "1", required = true, value = "The international phone number calling code.")
  @NotNull


  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public PhoneNumber digits(String digits) {
    this.digits = digits;
    return this;
  }

  /**
   * The phone number without prefix or country code.
   * @return digits
  **/
  @ApiModelProperty(example = "6365557322", required = true, value = "The phone number without prefix or country code.")
  @NotNull


  public String getDigits() {
    return digits;
  }

  public void setDigits(String digits) {
    this.digits = digits;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhoneNumber phoneNumber = (PhoneNumber) o;
    return Objects.equals(this.countryCode, phoneNumber.countryCode) &&
        Objects.equals(this.digits, phoneNumber.digits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(countryCode, digits);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhoneNumber {\n");
    
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    digits: ").append(toIndentedString(digits)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

