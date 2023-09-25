package ru.job4j.lombok;

import lombok.*;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {
    @EqualsAndHashCode.Include
    private int id;
    @Setter
    private String name;

    public Category(int id) {
        this.id = id;
    }
}
