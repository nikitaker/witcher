package web.witcher.Responces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TypeSquadResponse {

    private String typeName;
    private int costs;
    private long forcePerPerson;
}
