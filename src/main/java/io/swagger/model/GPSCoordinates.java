package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GPSCoordinates
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-09T09:53:33.998-03:00")

public class GPSCoordinates   {
  @JsonProperty("longitude")
  private BigDecimal longitude = null;

  @JsonProperty("latitude")
  private BigDecimal latitude = null;

  public GPSCoordinates longitude(BigDecimal longitude) {
    this.longitude = longitude;
    return this;
  }

  /**
   * The longitude for the site.
   * @return longitude
  **/
  @ApiModelProperty(example = "-90.513022", required = true, value = "The longitude for the site.")
  @NotNull

  @Valid

  public BigDecimal getLongitude() {
    return longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }

  public GPSCoordinates latitude(BigDecimal latitude) {
    this.latitude = latitude;
    return this;
  }

  /**
   * The latitude for the site.
   * @return latitude
  **/
  @ApiModelProperty(example = "38.786271", required = true, value = "The latitude for the site.")
  @NotNull

  @Valid

  public BigDecimal getLatitude() {
    return latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GPSCoordinates gpSCoordinates = (GPSCoordinates) o;
    return Objects.equals(this.longitude, gpSCoordinates.longitude) &&
        Objects.equals(this.latitude, gpSCoordinates.latitude);
  }

  @Override
  public int hashCode() {
    return Objects.hash(longitude, latitude);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GPSCoordinates {\n");
    
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
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

