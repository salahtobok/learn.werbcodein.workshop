package com.webcodein.shop.product;

import java.util.List;

public record ProductMetadata(String manufacturer, int warrantyYears, List<String> tags) {
}
