package ar.com.capitole.infraestructure.adapter.in.controllers.price;

import ar.com.capitole.application.ports.in.PriceServicePort;
import ar.com.capitole.domain.model.entity.Brand;
import ar.com.capitole.domain.model.entity.Price;
import ar.com.capitole.domain.model.entity.Product;
import ar.com.capitole.infraestructure.adapter.in.controllers.price.model.PriceResponse;
import ar.com.capitole.infraestructure.adapter.in.controllers.price.model.Error;
import ar.com.capitole.infraestructure.adapter.in.controllers.price.model.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class PriceController {

    private final PriceServicePort priceServicePort;

    @Operation(summary = "Get a price by id", description = "Returns a price as per the id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved",
                    content = @Content(
                            schema = @Schema(implementation = PriceResponse.class),
                            mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @GetMapping(value = "/price", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Response<PriceResponse, Error> getPriceForDate(@RequestParam(name = "brand_id") Long brandId,
                                                          @RequestParam(name = "product_id") Long productId,
                                                          @RequestParam
                                                          @Valid
                                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                          LocalDateTime date) {
        Price result = priceServicePort.findPriceWithHigherPriorityForTheDay(
                Brand.builder().id(brandId).build(),
                Product.builder().id(productId).build(),
                date);

        return Response.ok(PriceResponse.from(result));
    }
}
