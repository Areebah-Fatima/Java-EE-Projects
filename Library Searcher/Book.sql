-- Uncomment If tables are already created (doing otherwise will cause errors)
/*
drop table WrittenBy;
drop table Author;
drop table Book;
*/

-- Create Table one: Book to hold bookname, pgs, isbn. Primary key will be isbn
create table Book
(
   title varchar(50),
   pages integer,
   isbn char(13),
   primary key(isbn)
);

-- Create Table two: Author to hold id, names. Primary key will be id
create table Author
(
   id integer,
   author varchar(50),
   primary key(id)
);

-- Create Table three: WrittenBy to hold id, isbn. Primary key will be id,isbn. It will relate the tables together
create table WrittenBy
(
   id integer,
   isbn char(13),
   primary key(id, isbn),
   foreign key(id) references Author,
   foreign key(isbn) references Book
);

-- Matching the assignment info we will insert all our info about each book
insert into Book (title, pages, isbn)
values ('C++ Programming', 1020, '0-13-403732-4');

insert into Book (title, pages, isbn)
values ('Java Programming', 1344, '0-13-376131-2');

insert into Book (title, pages, isbn)
values ('Data Structures', 640, '0-13-257627-9');

insert into Book (title, pages, isbn)
values ('Python', 648, '0-13-257637-6');

insert into Book (title, pages, isbn)
values ('Problem Solving', 1024, '0-32-154140-5');

insert into Book (title, pages, isbn)
values ('EJB 3', 452, '1-43-024692-8');


-- Matching the assignment info we will insert all the authors
insert into Author (id, author)
values (1, 'Tony Gaddis');

insert into Author (id, author)
values (2, 'Y. Daniel Liang');

insert into Author (id, author)
values (3, 'Mark Allen Weiss');

insert into Author (id, author)
values (4, 'Jonathan Wetherbee');

insert into Author (id, author)
values (5, 'Chirag Rathod');


-- Matching the assignment info we will relate the author to their books
insert into WrittenBy (id, isbn)
values (1, '0-13-403732-4');

insert into WrittenBy (id, isbn)
values (1, '0-13-257637-6');

insert into WrittenBy (id, isbn)
values (2, '0-13-376131-2');

insert into WrittenBy (id, isbn)
values (3, '0-13-257627-9');

insert into WrittenBy (id, isbn)
values (3, '0-32-154140-5');

insert into WrittenBy (id, isbn)
values (4, '1-43-024692-8');

insert into WrittenBy (id, isbn)
values (5, '1-43-024692-8');