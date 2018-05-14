package qless.merchant.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import qless.merchant.model.APIError;
import qless.merchant.model.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-09T09:53:33.998-03:00")

@Api(value = "merchant", description = "the merchant API")
public interface MerchantApi {

    @ApiOperation(value = "Returns a uniquely-identified merchant location", nickname = "merchantLocationGet", notes = "This method returns a single merchant location that matches a unique global identifier.  The global identifier is returned in a NetworkSource entity with a 'location' type, usually in response to a location search query.", response = Location.class, tags={ "default", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Location matching the global identifier.", response = Location.class),
        @ApiResponse(code = 404, message = "No records found.", response = APIError.class),
        @ApiResponse(code = 500, message = "Unexpected service failure.", response = APIError.class),
        @ApiResponse(code = 502, message = "Invalid response from an upstream server.", response = APIError.class) })
    @RequestMapping(value = "/merchant/location/{location_gid}",
        produces = { "application/json" }, 
//        consumes = { "application/json" }, API error?
        method = RequestMethod.GET)
    ResponseEntity merchantLocationGet(@ApiParam(value = "",required=true) @PathVariable("location_gid") String locationGid,@ApiParam(value = "If set, limits result to locations having/restricting mobile access.") @Valid @RequestParam(value = "mobileClientAccess", required = false) Boolean mobileClientAccess,@ApiParam(value = "If true, omit the merchant information from returned locations.") @Valid @RequestParam(value = "omitMerchantInfo", required = false) Boolean omitMerchantInfo,@ApiParam(value = "If true, omit the contact information from returned locations.") @Valid @RequestParam(value = "omitContactInfo", required = false) Boolean omitContactInfo,@ApiParam(value = "If true, omit the list of supported consumer features from the returned locations.") @Valid @RequestParam(value = "omitConsumerFeatures", required = false) Boolean omitConsumerFeatures,@ApiParam(value = "An optional fields mask" ) @RequestHeader(value="X-Fields", required=false) String xFields);


    @ApiOperation(value = "Returns merchant locations that match search criteria", nickname = "merchantLocationSearch", notes = "This method identifies valid locations that match ALL provided search criteria.  Simpler queries work best for experimentation and early development, whereas multi-parameter queries permit strict optimization of client data usage.", response = Location.class, responseContainer = "List", tags={ "default", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Location(s) matching the search parameters.", response = Location.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid request parameter(s).", response = APIError.class),
        @ApiResponse(code = 404, message = "No records found.", response = APIError.class),
        @ApiResponse(code = 500, message = "Unexpected service failure.", response = APIError.class),
        @ApiResponse(code = 502, message = "Invalid response from an upstream server.", response = APIError.class) })
    @RequestMapping(value = "/merchant/location",
        produces = { "application/json" }, 
//        consumes = { "application/json" }, API error?
        method = RequestMethod.GET)
    ResponseEntity merchantLocationSearch(@ApiParam(value = "Identify and sort merchants or locations for which the search text offers approximate matches.") @Valid @RequestParam(value = "searchText", required = false) String searchText,@ApiParam(value = "Limits results to a region with its center specified by the given GPS longitude.") @Valid @RequestParam(value = "longitude", required = false) BigDecimal longitude,@ApiParam(value = "Limits results to a region with its center specified by the given GPS latitude.") @Valid @RequestParam(value = "latitude", required = false) BigDecimal latitude,@ApiParam(value = "Radius of the search area in meters.", defaultValue = "50000") @Valid @RequestParam(value = "searchRadius", required = false, defaultValue="50000") Integer searchRadius,@ApiParam(value = "Limits/queries locations by the provided global identifier.") @Valid @RequestParam(value = "gid", required = false) List<String> gid,@Min(1) @Max(100) @ApiParam(value = "The maximum number of locations to return for a single query.", defaultValue = "10") @Valid @RequestParam(value = "maximumResults", required = false, defaultValue="10") Integer maximumResults,@ApiParam(value = "If set, limits results to locations having/restricting mobile access.") @Valid @RequestParam(value = "mobileClientAccess", required = false) Boolean mobileClientAccess,@ApiParam(value = "If true, omit the merchant information from returned locations.") @Valid @RequestParam(value = "omitMerchantInfo", required = false) Boolean omitMerchantInfo,@ApiParam(value = "If true, omit the contact information from returned locations.") @Valid @RequestParam(value = "omitContactInfo", required = false) Boolean omitContactInfo,@ApiParam(value = "If true, omit the list of supported consumer features from the returned locations.") @Valid @RequestParam(value = "omitConsumerFeatures", required = false) Boolean omitConsumerFeatures,@ApiParam(value = "An optional fields mask" ) @RequestHeader(value="X-Fields", required=false) String xFields);

}
