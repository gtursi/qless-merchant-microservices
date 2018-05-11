package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.APIError;
import io.swagger.model.Location;
import io.swagger.repository.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-09T09:53:33.998-03:00")

@Controller
public class MerchantApiController implements MerchantApi {

    private static final Logger log = LoggerFactory.getLogger(MerchantApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final LocationRepository locationRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public MerchantApiController(ObjectMapper objectMapper, HttpServletRequest request, LocationRepository locationRepository) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.locationRepository = locationRepository;
    }

    public ResponseEntity merchantLocationGet(
    		@ApiParam(value = "",required=true) @PathVariable("location_gid") String locationGid,
			@ApiParam(value = "If set, limits result to locations having/restricting mobile access.") @Valid @RequestParam(value = "mobileClientAccess", required = false) Boolean mobileClientAccess,
			@ApiParam(value = "If true, omit the merchant information from returned locations.") @Valid @RequestParam(value = "omitMerchantInfo", required = false) Boolean omitMerchantInfo,
			@ApiParam(value = "If true, omit the contact information from returned locations.") @Valid @RequestParam(value = "omitContactInfo", required = false) Boolean omitContactInfo,
			@ApiParam(value = "If true, omit the list of supported consumer features from the returned locations.") @Valid @RequestParam(value = "omitConsumerFeatures", required = false) Boolean omitConsumerFeatures,
			@ApiParam(value = "An optional fields mask" ) @RequestHeader(value="X-Fields", required=false) String xFields) {

		if(locationGid == null){
			return new ResponseEntity<APIError>(new APIError("Invalid request parameter(s)."), HttpStatus.BAD_REQUEST);
		}

		// TODO Use xFields to project fields
		Location location = locationRepository.findOne(locationGid, mobileClientAccess, omitMerchantInfo, omitContactInfo, omitConsumerFeatures);
		if(location == null){
			return new ResponseEntity<APIError>(new APIError("No records found."), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Location>(location, HttpStatus.OK);

	}

    public ResponseEntity merchantLocationSearch(
    		@ApiParam(value = "Identify and sort merchants or locations for which the search text offers approximate matches.") @Valid @RequestParam(value = "searchText", required = false) String searchText,
			@ApiParam(value = "Limits results to a region with its center specified by the given GPS longitude.") @Valid @RequestParam(value = "longitude", required = false) BigDecimal longitude,
			@ApiParam(value = "Limits results to a region with its center specified by the given GPS latitude.") @Valid @RequestParam(value = "latitude", required = false) BigDecimal latitude,
			@ApiParam(value = "Radius of the search area in meters.", defaultValue = "50000") @Valid @RequestParam(value = "searchRadius", required = false, defaultValue="50000") Integer searchRadius,
			@ApiParam(value = "Limits/queries locations by the provided global identifier.") @Valid @RequestParam(value = "gid", required = false) List<String> gid,
			@Min(1) @Max(100) @ApiParam(value = "The maximum number of locations to return for a single query.", defaultValue = "10") @Valid @RequestParam(value = "maximumResults", required = false, defaultValue="10") Integer maximumResults,
			@ApiParam(value = "If set, limits results to locations having/restricting mobile access.") @Valid @RequestParam(value = "mobileClientAccess", required = false) Boolean mobileClientAccess,
			@ApiParam(value = "If true, omit the merchant information from returned locations.") @Valid @RequestParam(value = "omitMerchantInfo", required = false) Boolean omitMerchantInfo,
			@ApiParam(value = "If true, omit the contact information from returned locations.") @Valid @RequestParam(value = "omitContactInfo", required = false) Boolean omitContactInfo,
			@ApiParam(value = "If true, omit the list of supported consumer features from the returned locations.") @Valid @RequestParam(value = "omitConsumerFeatures", required = false) Boolean omitConsumerFeatures,
			@ApiParam(value = "An optional fields mask" ) @RequestHeader(value="X-Fields", required=false) String xFields) {

		if(maximumResults != null && (maximumResults < 1 || maximumResults > 100)){
			return new ResponseEntity<APIError>(new APIError("Invalid request parameter(s)."), HttpStatus.BAD_REQUEST);
		}

		// TODO Use xFields to project fields
		List<Location> locations = locationRepository.findBy(searchText, longitude, latitude, searchRadius, gid, maximumResults, mobileClientAccess, omitMerchantInfo, omitContactInfo, omitConsumerFeatures);
		if(locations.isEmpty()){
			return new ResponseEntity<APIError>(new APIError("No records found."), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);
    }

}
