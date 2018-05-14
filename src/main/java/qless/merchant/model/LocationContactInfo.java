package qless.merchant.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LocationContactInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-09T09:53:33.998-03:00")

public class LocationContactInfo   {
  @JsonProperty("timeZone")
  private String timeZone = null;

  @JsonProperty("address")
  private Address address = null;

  @JsonProperty("phone")
  private PhoneNumber phone = null;

  @JsonProperty("fax")
  private PhoneNumber fax = null;

  @JsonProperty("gps")
  private GPSCoordinates gps = null;

  public LocationContactInfo timeZone(String timeZone) {
    this.timeZone = timeZone;
    return this;
  }

  /**
   * The Olson-formatted timezone.
   * @return timeZone
  **/
  @ApiModelProperty(example = "America/Chicago", required = true, value = "The Olson-formatted timezone.")
  @NotNull


  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  public LocationContactInfo address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public LocationContactInfo phone(PhoneNumber phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PhoneNumber getPhone() {
    return phone;
  }

  public void setPhone(PhoneNumber phone) {
    this.phone = phone;
  }

  public LocationContactInfo fax(PhoneNumber fax) {
    this.fax = fax;
    return this;
  }

  /**
   * Get fax
   * @return fax
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PhoneNumber getFax() {
    return fax;
  }

  public void setFax(PhoneNumber fax) {
    this.fax = fax;
  }

  public LocationContactInfo gps(GPSCoordinates gps) {
    this.gps = gps;
    return this;
  }

  /**
   * Get gps
   * @return gps
  **/
  @ApiModelProperty(value = "")

  @Valid

  public GPSCoordinates getGps() {
    return gps;
  }

  public void setGps(GPSCoordinates gps) {
    this.gps = gps;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationContactInfo locationContactInfo = (LocationContactInfo) o;
    return Objects.equals(this.timeZone, locationContactInfo.timeZone) &&
        Objects.equals(this.address, locationContactInfo.address) &&
        Objects.equals(this.phone, locationContactInfo.phone) &&
        Objects.equals(this.fax, locationContactInfo.fax) &&
        Objects.equals(this.gps, locationContactInfo.gps);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timeZone, address, phone, fax, gps);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocationContactInfo {\n");
    
    sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    fax: ").append(toIndentedString(fax)).append("\n");
    sb.append("    gps: ").append(toIndentedString(gps)).append("\n");
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

