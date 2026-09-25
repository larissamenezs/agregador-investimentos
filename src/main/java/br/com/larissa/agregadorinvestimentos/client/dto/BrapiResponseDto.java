package br.com.larissa.agregadorinvestimentos.client.dto;

import java.util.List;

public record BrapiResponseDto(List<StockDto> results) {
}
