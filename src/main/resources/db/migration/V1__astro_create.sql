-- 星座个信信息
create table if not exists `astro_basic_info` (
    info_id INTEGER PRIMARY KEY AUTOINCREMENT,
    name text not null,
    type INTEGER NOT NULL,
    strengths text default null,
    weaknesses text default null,
    likes text default null,
    dislikes text default null,
    story text default null
);
