package domain;

import jakarta.validation.constraints.*;

import java.util.UUID;

public record RequestProduct(
		
		String id,
        @NotBlank
        String name,
        @NotNull
        Integer price_in_cents
        ) {}
