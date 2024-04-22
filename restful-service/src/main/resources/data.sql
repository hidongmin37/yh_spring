insert into tbl_users(id,join_date,name,password,ssn) values(90001,now(),'USER1','test111','701010-1111111');
insert into tbl_users(id,join_date,name,password,ssn) values(90002,now(),'USER2','test222','801212-1111111');
insert into tbl_users(id,join_date,name,password,ssn) values(90003,now(),'USER3','test333','901111-1111111');

insert into post(description, user_id) values ('첫 게시물', 90001);
insert into post(description, user_id) values ('두번째 게시물', 90001);
insert into post(description, user_id) values ('첫 게시물', 90002);
