package qless.merchant.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Merchant
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-09T09:53:33.998-03:00")

public class Merchant   {
  @JsonProperty("source")
  private NetworkSource source = null;

  @JsonProperty("name")
  private String name = null;

  public Merchant source(NetworkSource source) {
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

  public Merchant name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The merchant descriptive name.
   * @return name
  **/
  @ApiModelProperty(example = "Super Speedy, Inc.", required = true, value = "The merchant descriptive name.")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Merchant merchant = (Merchant) o;
    return Objects.equals(this.source, merchant.source) &&
        Objects.equals(this.name, merchant.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(source, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Merchant {\n");
    
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

