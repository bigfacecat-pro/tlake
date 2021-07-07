empreport接口规范：

提交参数

| 参数  | 说明   |      |      |
| ----- | ------ | ---- | ---- |
| page  | 页码   |      |      |
| empID | 员工ID |      |      |
|       |        |      |      |

返回参数

| 参数    | 说明     | 示例    |
| ------- | -------- | ------- |
| code    | 状态码   | success |
| data    | 数据     |         |
| message | 提示文本 |         |
|         |          |         |



```sql
select name, sum(receptionCount) as receptionCount,sum(fiveStarCount) as fiveStarCount, sum(fourStarCount) as fourStarCount,
        sum(threeStarCount) as threeStarCount,sum(twoStarCount) as twoStarCount,sum(oneStarCount) as oneStarCount
        from workRecord
        where timeDate between 0 and 2022;



select e.name, sum(w.receptionCount) ,sum(w.fiveStarCount) , sum(w.fourStarCount) ,
       sum(w.threeStarCount) ,sum(w.twoStarCount) ,sum(w.oneStarCount)
from workRecord as w inner join employee  as e
on w.employeeID=e.employeeID
where w.timeDate between 0 and 2022 group by w.employeeID;
```