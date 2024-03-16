SELECT FLAVOR
FROM (
    SELECT a.FLAVOR, a.TOTAL_ORDER AS TOTAL
    FROM JULY a
    
    union ALL

    SELECT a.FLAVOR, a.TOTAL_ORDER AS TOTAL
    FROM FIRST_HALF a
) tb1
GROUP BY FLAVOR
ORDER BY SUM(TOTAL) DESC
LIMIT 3;