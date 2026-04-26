package uk.ac.mmu.enterpriseprogramming.model.data;

public record BookVO(
    int id,
    String title,
    String author,
    String date,
    String genres,
    String characters,
    String synopsis,
    String coverUrl
) {}