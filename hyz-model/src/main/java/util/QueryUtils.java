package util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import page.PageResult;

import java.util.List;

/**
 * @author add by huyingzhao
 * 2022-08-31 20:32
 */
public class QueryUtils {
//    /**
//     * @param mongoTemplate mongoTemplate
//     * @param is            false:fuzzy query
//     *                      true:accurate query
//     * @param index         index
//     * @param size          size
//     * @param aClass        aClass
//     * @param beginDate     beginDate
//     * @param endDate       endDate
//     * @return query
//     * @author add by huyingzhao
//     * 2022-06-10 21:51
//     */
//    public static <T> PageResult<List<T>> query(MongoTemplate mongoTemplate, boolean is,
//                                                Map<String, Object> objectMap, int index,
//                                                int size, Class<T> aClass, Date beginDate, Date endDate) {
//        long begin = (long) (index - 1) * size;
//        Query query = new Query();
//        Criteria criteria = Criteria.where("_id").ne(null).ne("");
//        if (objectMap != null && !objectMap.isEmpty()) {
//            for (Map.Entry<String, Object> objectEntry : objectMap.entrySet()) {
//                Object o = objectEntry.getValue();
//                String key = objectEntry.getKey();
//                if (o != null) {
//                    if (o instanceof String) {
//                        if (!(((String) o).isEmpty())) {
//                            if (is) {
//                                criteria.and(key).is(o);
//                            } else {
//                                Pattern pattern = Pattern.compile("^.*" + o + ".*$", Pattern.CASE_INSENSITIVE);
//                                criteria.and(key).regex(pattern);
//                            }
//
//                        }
//                    } else if (o instanceof Date) {
//                        if (beginDate != null && endDate != null) {
//                            nowDate(criteria, key, beginDate, endDate);
//                        }
//                    }
//                }
//            }
//        }
//
//        query.addCriteria(criteria);
//        long total = mongoTemplate.count(query, aClass);
//        if (begin >= total) {
//            return PageResult.warning("no data", new ArrayList<>());
//        }
//
//        if (size > 0) {
//            query.skip(begin);
//            query.limit(size);
//        }
//
//        PageResult<List<T>> result = PageResult.success("query success", mongoTemplate.find(query, aClass));
//        result.setNowPage(index);
//        if (size > 0) {
//            result.setPageSize(size);
//        } else {
//            result.setPageSize(total);
//        }
//
//        result.setTotal(total);
//        return result;
//    }
//
//    /**
//     * @param pageSize pageSize
//     * @param nowPage  nowPage
//     * @param code     code
//     * @param type     type
//     * @param msg      msg
//     * @param data     data
//     * @param <T>      <T>
//     * @return query
//     * @author method add by huyingzhao
//     * 2022-10-13 17:13
//     */
//    public static <T> PageResult<List<T>> query(int pageSize, int nowPage, String code, String type, String msg, List<T> data) {
//        PageResult<List<T>> pageResult = new PageResult<>(code, type, msg, data);
//        if (!data.isEmpty()) {
//            int total = data.size();
//            if (total > pageSize) {
//                int toIndex = pageSize * nowPage;
//                if (toIndex > total) {
//                    toIndex = total;
//                }
//                int totalPage = total % pageSize == 0 ? (total / pageSize) : (total / pageSize) + 1;
//                if (totalPage < nowPage) {
//                    data = new ArrayList<>();
//                } else {
//                    data = data.subList(pageSize * (nowPage - 1), toIndex);
//                }
//            }
//
//            pageResult.setData(data);
//            pageResult.setTotal(total);
//            pageResult.setNowPage(nowPage);
//            pageResult.setPageSize(pageSize);
//        }
//        return pageResult;
//    }
//
//    /**
//     * @param criteria criteria
//     * @param name     name
//     * @param begin    begin
//     * @param end      end
//     * @author add by huyingzhao
//     * 2022-06-27 9:44
//     */
//    private static void nowDate(Criteria criteria, String name, Date begin, Date end) {
//        if (begin == null) {
//            begin = DateUtil.nowTime();
//        }
//
//        if (end == null) {
//            end = DateUtil.nowTime();
//        }
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(begin);
//        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE) - 1, 23, 59,
//                59);
//        Date yesterday = calendar.getTime();
//        calendar.setTime(end);
//        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE) + 1, 0, 0,
//                0);
//        Date tomorrow = calendar.getTime();
//        criteria.and(name).gt(yesterday).lt(tomorrow);
//    }
//
//    public static  <T> List<T> query(MongoTemplate mongoTemplate, Class<T> entityClass, int pageNumber, int pageSize, Criteria criteria, Sort sort) {
//        // Set the pagination parameters
//        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize, sort);
//        // Create a query object
//        Query query = new Query(criteria);
//        query.with(pageRequest);
//        // Execute the query and retrieve the results
//        List<T> documents = mongoTemplate.find(query, entityClass);
//        // Return the results
//        return documents;
//    }

    public static <T> PageResult<T> query(String msg, MongoTemplate mongoTemplate, Class<T> entityClass, int pageNumber, int pageSize, Criteria criteria, Sort sort) {
        long totalElements = mongoTemplate.count(Query.query(criteria), entityClass);
        int totalPages = (int) Math.ceil((double) totalElements / pageSize);

        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        Query query = Query.query(criteria).with(pageable);
        List<T> content = mongoTemplate.find(query, entityClass);
        return PageResult.success(msg, totalElements, totalPages, pageNumber, pageSize, content);
    }
}
