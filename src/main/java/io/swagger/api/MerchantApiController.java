package io.swagger.api;

import io.swagger.model.APIError;
import java.math.BigDecimal;
import io.swagger.model.Location;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-09T09:53:33.998-03:00")

@Controller
public class MerchantApiController implements MerchantApi {

    private static final Logger log = LoggerFactory.getLogger(MerchantApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final Supplier<Stream<Location>> locationData;

    @org.springframework.beans.factory.annotation.Autowired
    public MerchantApiController(ObjectMapper objectMapper, HttpServletRequest request, Supplier<Stream<Location>> locationData) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.locationData = locationData;
    }

    public ResponseEntity<Location> merchantLocationGet(@ApiParam(value = "",required=true) @PathVariable("location_gid") String locationGid,@ApiParam(value = "If set, limits result to locations having/restricting mobile access.") @Valid @RequestParam(value = "mobileClientAccess", required = false) Boolean mobileClientAccess,@ApiParam(value = "If true, omit the merchant information from returned locations.") @Valid @RequestParam(value = "omitMerchantInfo", required = false) Boolean omitMerchantInfo,@ApiParam(value = "If true, omit the contact information from returned locations.") @Valid @RequestParam(value = "omitContactInfo", required = false) Boolean omitContactInfo,@ApiParam(value = "If true, omit the list of supported consumer features from the returned locations.") @Valid @RequestParam(value = "omitConsumerFeatures", required = false) Boolean omitConsumerFeatures,@ApiParam(value = "An optional fields mask" ) @RequestHeader(value="X-Fields", required=false) String xFields) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Location>(objectMapper.readValue("{  \"contactInfo\" : {    \"address\" : {      \"city\" : \"St. Charles\",      \"postalCode\" : \"63301\",      \"isoCountryCode\" : \"US\",      \"addressLines\" : [ \"123 South Main St.\" ],      \"state\" : \"MO\"    },    \"phone\" : {      \"countryCode\" : \"1\",      \"digits\" : \"6365557322\"    },    \"timeZone\" : \"America/Chicago\",    \"gps\" : {      \"latitude\" : 38.786271,      \"longitude\" : -90.513022    },    \"fax\" : {      \"countryCode\" : \"1\",      \"digits\" : \"6365557322\"    }  },  \"name\" : \"Speedy DMV\",  \"description\" : \"Speedy DMV, St. Charles\",  \"source\" : {    \"hostName\" : \"merchant.qless.com\",    \"globalId\" : \"514E898949227FE83D4F51F238354B6F91BE3DAF\",    \"indirectId\" : \"5f69bd28-2ba2-4f7a-b89b-224a323d0843\",    \"hostId\" : \"10512\",    \"type\" : \"location\"  },  \"merchantInfo\" : {    \"name\" : \"Super Speedy, Inc.\",    \"source\" : {      \"hostName\" : \"merchant.qless.com\",      \"globalId\" : \"514E898949227FE83D4F51F238354B6F91BE3DAF\",      \"indirectId\" : \"5f69bd28-2ba2-4f7a-b89b-224a323d0843\",      \"hostId\" : \"10512\",      \"type\" : \"location\"    }  },  \"consumerFeatures\" : {    \"hasCustomScreens\" : false,    \"hasMobileAccess\" : true,    \"supportedLocales\" : [ \"en_US\", \"es_ES\" ],    \"hasVoiceQueuing\" : true,    \"maxSimultaneousQueues\" : 1,    \"supportsPartySize\" : false,    \"hasTransactionTypes\" : true,    \"hasAppointments\" : true,    \"hasSMSSummoning\" : false,    \"shouldDisplayTransactionTypesBeforeQueues\" : false  }}", Location.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Location>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Location>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Location>> merchantLocationSearch(
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
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Location> locations = locationData.get().
                    filter(location -> location.filterByText(searchText)).
                    // TODO: use longitude and latitude plus radius
                    filter(location -> location.filterByLongitude(longitude)).
                    filter(location -> location.filterByLatitude(latitude)).
					filter(location -> location.filterByGlobalId(gid))
					.filter(location -> location.filterByMobileClientAcces(mobileClientAccess))
					.map(location -> location.clone(omitMerchantInfo, omitContactInfo, omitConsumerFeatures))
					.limit(maximumResults).
                    collect(Collectors.toList());

            return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);
        }

        return new ResponseEntity<List<Location>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
