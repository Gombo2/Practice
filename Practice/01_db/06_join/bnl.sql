SET SESSION optimizer_switch='join_cache_incremental=on';
SET SESSION optimizer_switch='join_cache_hashed=on';
SET SESSION optimizer_switch='join_cache_bka=on';
SET SESSION join_cache_level=2; -- 어던 방식으로 할지.

select count(*) from t1 join t2 on t1.c2 = t2.c2;
explain select count(*) from t1 join t2 on t1.c2 = t2.c2;