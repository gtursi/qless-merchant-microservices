package io.swagger.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ConsumerFeatures;
import io.swagger.model.LocationContactInfo;
import io.swagger.model.Merchant;
import io.swagger.model.NetworkSource;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import static java.lang.Boolean.*;

/**
 * Location
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-09T09:53:33.998-03:00")

public class Location implements Cloneable {
  @JsonProperty("source")
  private NetworkSource source = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("merchantInfo")
  private Merchant merchantInfo = null;

  @JsonProperty("contactInfo")
  private LocationContactInfo contactInfo = null;

  @JsonProperty("consumerFeatures")
  private ConsumerFeatures consumerFeatures = null;

  public Location source(NetworkSource source) {
    this.source = source;
    return this;
  }

  /**
   * Get source
   * @return source
  **/
  @ApiModelProperty(value = "")

  @Valid

  public NetworkSource getSource() {
    return source;
  }

  public void setSource(NetworkSource source) {
    this.source = source;
  }

  public Location name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The human-readable name of this location.
   * @return name
  **/
  @ApiModelProperty(example = "Speedy DMV", required = true, value = "The human-readable name of this location.")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Location description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Descriptive text for this location.
   * @return description
  **/
  @ApiModelProperty(example = "Speedy DMV, St. Charles", value = "Descriptive text for this location.")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Location merchantInfo(Merchant merchantInfo) {
    this.merchantInfo = merchantInfo;
    return this;
  }

  /**
   * Get merchantInfo
   * @return merchantInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Merchant getMerchantInfo() {
    return merchantInfo;
  }

  public void setMerchantInfo(Merchant merchantInfo) {
    this.merchantInfo = merchantInfo;
  }

  public Location contactInfo(LocationContactInfo contactInfo) {
    this.contactInfo = contactInfo;
    return this;
  }

  /**
   * Get contactInfo
   * @return contactInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocationContactInfo getContactInfo() {
    return contactInfo;
  }

  public void setContactInfo(LocationContactInfo contactInfo) {
    this.contactInfo = contactInfo;
  }

  public Location consumerFeatures(ConsumerFeatures consumerFeatures) {
    this.consumerFeatures = consumerFeatures;
    return this;
  }

  /**
   * Get consumerFeatures
   * @return consumerFeatures
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ConsumerFeatures getConsumerFeatures() {
    return consumerFeatures;
  }

  public void setConsumerFeatures(ConsumerFeatures consumerFeatures) {
    this.consumerFeatures = consumerFeatures;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return Objects.equals(this.source, location.source) &&
        Objects.equals(this.name, location.name) &&
        Objects.equals(this.description, location.description) &&
        Objects.equals(this.merchantInfo, location.merchantInfo) &&
        Objects.equals(this.contactInfo, location.contactInfo) &&
        Objects.equals(this.consumerFeatures, location.consumerFeatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(source, name, description, merchantInfo, contactInfo, consumerFeatures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");
    
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    merchantInfo: ").append(toIndentedString(merchantInfo)).append("\n");
    sb.append("    contactInfo: ").append(toIndentedString(contactInfo)).append("\n");
    sb.append("    consumerFeatures: ").append(toIndentedString(consumerFeatures)).append("\n");
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

  public boolean filterByText(String searchText) {
  	if(getName() != null && searchText != null) {
		return getName().contains(searchText);
	}
	return true;
  }

  public boolean filterByLongitude(BigDecimal longitude) {
  	if(getContactInfo().getGps().getLongitude() != null && longitude != null){
  		return getContactInfo().getGps().getLongitude().equals(longitude);
	}
    return true;
  }

	public boolean filterByLatitude(BigDecimal latitude) {
		if(getContactInfo().getGps().getLatitude() != null && latitude != null){
			return getContactInfo().getGps().getLatitude().equals(latitude);
		}
		return true;
	}

	public boolean filterByGlobalId(List<String> gid) {
  		if(gid != null && !gid.isEmpty()) {
			throw new RuntimeException("Method not implemented");
		}
		return true;
	}

	public boolean filterByMobileClientAcces(Boolean mobileClientAccess) {
  		return getConsumerFeatures().filterByMobileClientAccess(mobileClientAccess);
	}

	public Location clone() throws CloneNotSupportedException {
  		return (Location) super.clone();
	}
	public Location clone(Boolean omitMerchantInfo, Boolean omitContactInfo, Boolean omitConsumerFeatures)  {
		Location clone = null;
		try {
			clone = this.clone();
			if(TRUE.equals(omitMerchantInfo)){
				clone.setMerchantInfo(null);
			}
			if(TRUE.equals(omitContactInfo)){
				clone.setContactInfo(null);
			}
			if(TRUE.equals(omitConsumerFeatures)){
				clone.setConsumerFeatures(null);
			}
		} catch (CloneNotSupportedException e) {
			// clone is supported
		}
  		return clone;
	}
}

