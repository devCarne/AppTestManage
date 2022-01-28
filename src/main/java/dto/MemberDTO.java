package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class MemberDTO {
    String id;
    String pw;
    String name;
    Date regDate;
}
