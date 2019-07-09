create table login(
username varchar(50) not null,
password varchar(50));


insert into login values("admin", "admin@123"); 
insert into login values("admin", "admin@123"); 

create table RTTD_009 (
ProductName varchar(50) not null
,MetaTitle varchar(50) not null
,Model varchar(50) not null
,Price varchar(10)
,Category varchar(20)
,Quantity varchar(50)
,DiscountPrice varchar(50)
,Points varchar(10)
);

insert into RTTD_009 values("Samsung", "Samsung", "SKU-003", "20000", "TV", "5", "300", "5");
insert into RTTD_009 values("Onida", "Onida", "SKU-003", "18000", "TV", "4", "400", "10");
insert into RTTD_009 values("Bat", "Cricket Bat", "SKU-003", "12000", "Sports", "3", "600", "12");
insert into RTTD_009 values("Asus", "Asus Zenfone", "SKU-003", "7000", "Electronic", "6", "600", "15");

create table RTTD_010 (
ProductName varchar(50)
,MetaTitle varchar(50)
,Model varchar(300)
,Price varchar(10)
,Category varchar(20)
,Quantity varchar(50)
,DiscountPrice varchar(50)
,Points varchar(10)
);

insert into RTTD_010 values(" ", " ", " ", "  ", "TV", " ", " ", " ");
insert into RTTD_010 values("Onida", "TV", " ", " ", "TV", " ", " ", " ");
insert into RTTD_010 values("Bat", "Cricket Bat", " ahlkslkdlkjlkfjdslflkjdslkfjdslkjflkdsjflkdsjlkgglkdjglkjlkfjlgkjfdlkjfdlkjglkfdjglkfdjglkjfdlkgjflkjglkfdjglkfdjglkfdjglkjfdlkgjlkjglkdjlkfdjgrehoiteoiruioreu", " ", "Sports", " ", " ", " ");
insert into RTTD_010 values("as", "Asus Zenfone", "SKU-003", "7000", "Electronic", "6", "600", "15");