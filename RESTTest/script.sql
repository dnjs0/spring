select * from tbladdress;
select * from tblmemo;

select * from tbladdress a inner join tblmemo m on a.seq=m.aseq where a.seq=2;

select
    a.*,
    m.*,
    a.seq as dseq,
    m.seq as mseq
from tbladdress a 
    inner join tblmemo m 
        on a.seq=m.aseq where a.seq=2;
        
        
select * from tbladdress order by seq desc;
select * from tblmemo;