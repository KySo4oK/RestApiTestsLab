package models;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FakeEntity extends SimpleEntity {
    public FakeEntity(long l, String name) {
        super(l, name);
    }
}
