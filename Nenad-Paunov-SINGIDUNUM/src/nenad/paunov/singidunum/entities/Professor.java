package nenad.paunov.singidunum.entities;

import javax.persistence.ManyToOne;

public class Professor extends Person{
private java.sql.Date reelectionDate;
@ManyToOne
private Title title;
}
