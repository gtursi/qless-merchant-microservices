package qless.merchant.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * NetworkSource
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-09T09:53:33.998-03:00")

public class NetworkSource   {
  /**
   * The source data category that this object identifies.
   */
  public enum TypeEnum {
    LOCATION("location"),
    
    MERCHANT("merchant");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("globalId")
  private String globalId = null;

  @JsonProperty("hostName")
  private String hostName = null;

  @JsonProperty("hostId")
  private String hostId = null;

  @JsonProperty("indirectId")
  private String indirectId = null;

  public NetworkSource type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * The source data category that this object identifies.
   * @return type
  **/
  @ApiModelProperty(example = "location", required = true, value = "The source data category that this object identifies.")
  @NotNull


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public NetworkSource globalId(String globalId) {
    this.globalId = globalId;
    return this;
  }

  /**
   * A globally-unique identification for the associated data element within this API.
   * @return globalId
  **/
  @ApiModelProperty(example = "514E898949227FE83D4F51F238354B6F91BE3DAF", required = true, value = "A globally-unique identification for the associated data element within this API.")
  @NotNull


  public String getGlobalId() {
    return globalId;
  }

  public void setGlobalId(String globalId) {
    this.globalId = globalId;
  }

  public NetworkSource hostName(String hostName) {
    this.hostName = hostName;
    return this;
  }

  /**
   * The host environment that owns the data element.
   * @return hostName
  **/
  @ApiModelProperty(example = "merchant.qless.com", required = true, value = "The host environment that owns the data element.")
  @NotNull


  public String getHostName() {
    return hostName;
  }

  public void setHostName(String hostName) {
    this.hostName = hostName;
  }

  public NetworkSource hostId(String hostId) {
    this.hostId = hostId;
    return this;
  }

  /**
   * The QLess environment-specific identifier for the data element.
   * @return hostId
  **/
  @ApiModelProperty(example = "10512", required = true, value = "The QLess environment-specific identifier for the data element.")
  @NotNull


  public String getHostId() {
    return hostId;
  }

  public void setHostId(String hostId) {
    this.hostId = hostId;
  }

  public NetworkSource indirectId(String indirectId) {
    this.indirectId = indirectId;
    return this;
  }

  /**
   * A globally-unique (GUUID) identification for the associated object and is equivalent to the QLess indirectId in its database.
   * @return indirectId
  **/
  @ApiModelProperty(example = "5f69bd28-2ba2-4f7a-b89b-224a323d0843", value = "A globally-unique (GUUID) identification for the associated object and is equivalent to the QLess indirectId in its database.")


  public String getIndirectId() {
    return indirectId;
  }

  public void setIndirectId(String indirectId) {
    this.indirectId = indirectId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkSource networkSource = (NetworkSource) o;
    return Objects.equals(this.type, networkSource.type) &&
        Objects.equals(this.globalId, networkSource.globalId) &&
        Objects.equals(this.hostName, networkSource.hostName) &&
        Objects.equals(this.hostId, networkSource.hostId) &&
        Objects.equals(this.indirectId, networkSource.indirectId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, globalId, hostName, hostId, indirectId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkSource {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    globalId: ").append(toIndentedString(globalId)).append("\n");
    sb.append("    hostName: ").append(toIndentedString(hostName)).append("\n");
    sb.append("    hostId: ").append(toIndentedString(hostId)).append("\n");
    sb.append("    indirectId: ").append(toIndentedString(indirectId)).append("\n");
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

