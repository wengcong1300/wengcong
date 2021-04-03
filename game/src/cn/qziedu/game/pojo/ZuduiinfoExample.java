package cn.qziedu.game.pojo;

import java.util.ArrayList;
import java.util.List;

public class ZuduiinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZuduiinfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFabuinfoidIsNull() {
            addCriterion("fabuinfoid is null");
            return (Criteria) this;
        }

        public Criteria andFabuinfoidIsNotNull() {
            addCriterion("fabuinfoid is not null");
            return (Criteria) this;
        }

        public Criteria andFabuinfoidEqualTo(Integer value) {
            addCriterion("fabuinfoid =", value, "fabuinfoid");
            return (Criteria) this;
        }

        public Criteria andFabuinfoidNotEqualTo(Integer value) {
            addCriterion("fabuinfoid <>", value, "fabuinfoid");
            return (Criteria) this;
        }

        public Criteria andFabuinfoidGreaterThan(Integer value) {
            addCriterion("fabuinfoid >", value, "fabuinfoid");
            return (Criteria) this;
        }

        public Criteria andFabuinfoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fabuinfoid >=", value, "fabuinfoid");
            return (Criteria) this;
        }

        public Criteria andFabuinfoidLessThan(Integer value) {
            addCriterion("fabuinfoid <", value, "fabuinfoid");
            return (Criteria) this;
        }

        public Criteria andFabuinfoidLessThanOrEqualTo(Integer value) {
            addCriterion("fabuinfoid <=", value, "fabuinfoid");
            return (Criteria) this;
        }

        public Criteria andFabuinfoidIn(List<Integer> values) {
            addCriterion("fabuinfoid in", values, "fabuinfoid");
            return (Criteria) this;
        }

        public Criteria andFabuinfoidNotIn(List<Integer> values) {
            addCriterion("fabuinfoid not in", values, "fabuinfoid");
            return (Criteria) this;
        }

        public Criteria andFabuinfoidBetween(Integer value1, Integer value2) {
            addCriterion("fabuinfoid between", value1, value2, "fabuinfoid");
            return (Criteria) this;
        }

        public Criteria andFabuinfoidNotBetween(Integer value1, Integer value2) {
            addCriterion("fabuinfoid not between", value1, value2, "fabuinfoid");
            return (Criteria) this;
        }

        public Criteria andEmailid1IsNull() {
            addCriterion("emailid1 is null");
            return (Criteria) this;
        }

        public Criteria andEmailid1IsNotNull() {
            addCriterion("emailid1 is not null");
            return (Criteria) this;
        }

        public Criteria andEmailid1EqualTo(Integer value) {
            addCriterion("emailid1 =", value, "emailid1");
            return (Criteria) this;
        }

        public Criteria andEmailid1NotEqualTo(Integer value) {
            addCriterion("emailid1 <>", value, "emailid1");
            return (Criteria) this;
        }

        public Criteria andEmailid1GreaterThan(Integer value) {
            addCriterion("emailid1 >", value, "emailid1");
            return (Criteria) this;
        }

        public Criteria andEmailid1GreaterThanOrEqualTo(Integer value) {
            addCriterion("emailid1 >=", value, "emailid1");
            return (Criteria) this;
        }

        public Criteria andEmailid1LessThan(Integer value) {
            addCriterion("emailid1 <", value, "emailid1");
            return (Criteria) this;
        }

        public Criteria andEmailid1LessThanOrEqualTo(Integer value) {
            addCriterion("emailid1 <=", value, "emailid1");
            return (Criteria) this;
        }

        public Criteria andEmailid1In(List<Integer> values) {
            addCriterion("emailid1 in", values, "emailid1");
            return (Criteria) this;
        }

        public Criteria andEmailid1NotIn(List<Integer> values) {
            addCriterion("emailid1 not in", values, "emailid1");
            return (Criteria) this;
        }

        public Criteria andEmailid1Between(Integer value1, Integer value2) {
            addCriterion("emailid1 between", value1, value2, "emailid1");
            return (Criteria) this;
        }

        public Criteria andEmailid1NotBetween(Integer value1, Integer value2) {
            addCriterion("emailid1 not between", value1, value2, "emailid1");
            return (Criteria) this;
        }

        public Criteria andEmailid2IsNull() {
            addCriterion("emailid2 is null");
            return (Criteria) this;
        }

        public Criteria andEmailid2IsNotNull() {
            addCriterion("emailid2 is not null");
            return (Criteria) this;
        }

        public Criteria andEmailid2EqualTo(Integer value) {
            addCriterion("emailid2 =", value, "emailid2");
            return (Criteria) this;
        }

        public Criteria andEmailid2NotEqualTo(Integer value) {
            addCriterion("emailid2 <>", value, "emailid2");
            return (Criteria) this;
        }

        public Criteria andEmailid2GreaterThan(Integer value) {
            addCriterion("emailid2 >", value, "emailid2");
            return (Criteria) this;
        }

        public Criteria andEmailid2GreaterThanOrEqualTo(Integer value) {
            addCriterion("emailid2 >=", value, "emailid2");
            return (Criteria) this;
        }

        public Criteria andEmailid2LessThan(Integer value) {
            addCriterion("emailid2 <", value, "emailid2");
            return (Criteria) this;
        }

        public Criteria andEmailid2LessThanOrEqualTo(Integer value) {
            addCriterion("emailid2 <=", value, "emailid2");
            return (Criteria) this;
        }

        public Criteria andEmailid2In(List<Integer> values) {
            addCriterion("emailid2 in", values, "emailid2");
            return (Criteria) this;
        }

        public Criteria andEmailid2NotIn(List<Integer> values) {
            addCriterion("emailid2 not in", values, "emailid2");
            return (Criteria) this;
        }

        public Criteria andEmailid2Between(Integer value1, Integer value2) {
            addCriterion("emailid2 between", value1, value2, "emailid2");
            return (Criteria) this;
        }

        public Criteria andEmailid2NotBetween(Integer value1, Integer value2) {
            addCriterion("emailid2 not between", value1, value2, "emailid2");
            return (Criteria) this;
        }

        public Criteria andEmailid3IsNull() {
            addCriterion("emailid3 is null");
            return (Criteria) this;
        }

        public Criteria andEmailid3IsNotNull() {
            addCriterion("emailid3 is not null");
            return (Criteria) this;
        }

        public Criteria andEmailid3EqualTo(Integer value) {
            addCriterion("emailid3 =", value, "emailid3");
            return (Criteria) this;
        }

        public Criteria andEmailid3NotEqualTo(Integer value) {
            addCriterion("emailid3 <>", value, "emailid3");
            return (Criteria) this;
        }

        public Criteria andEmailid3GreaterThan(Integer value) {
            addCriterion("emailid3 >", value, "emailid3");
            return (Criteria) this;
        }

        public Criteria andEmailid3GreaterThanOrEqualTo(Integer value) {
            addCriterion("emailid3 >=", value, "emailid3");
            return (Criteria) this;
        }

        public Criteria andEmailid3LessThan(Integer value) {
            addCriterion("emailid3 <", value, "emailid3");
            return (Criteria) this;
        }

        public Criteria andEmailid3LessThanOrEqualTo(Integer value) {
            addCriterion("emailid3 <=", value, "emailid3");
            return (Criteria) this;
        }

        public Criteria andEmailid3In(List<Integer> values) {
            addCriterion("emailid3 in", values, "emailid3");
            return (Criteria) this;
        }

        public Criteria andEmailid3NotIn(List<Integer> values) {
            addCriterion("emailid3 not in", values, "emailid3");
            return (Criteria) this;
        }

        public Criteria andEmailid3Between(Integer value1, Integer value2) {
            addCriterion("emailid3 between", value1, value2, "emailid3");
            return (Criteria) this;
        }

        public Criteria andEmailid3NotBetween(Integer value1, Integer value2) {
            addCriterion("emailid3 not between", value1, value2, "emailid3");
            return (Criteria) this;
        }

        public Criteria andEmailid4IsNull() {
            addCriterion("emailid4 is null");
            return (Criteria) this;
        }

        public Criteria andEmailid4IsNotNull() {
            addCriterion("emailid4 is not null");
            return (Criteria) this;
        }

        public Criteria andEmailid4EqualTo(Integer value) {
            addCriterion("emailid4 =", value, "emailid4");
            return (Criteria) this;
        }

        public Criteria andEmailid4NotEqualTo(Integer value) {
            addCriterion("emailid4 <>", value, "emailid4");
            return (Criteria) this;
        }

        public Criteria andEmailid4GreaterThan(Integer value) {
            addCriterion("emailid4 >", value, "emailid4");
            return (Criteria) this;
        }

        public Criteria andEmailid4GreaterThanOrEqualTo(Integer value) {
            addCriterion("emailid4 >=", value, "emailid4");
            return (Criteria) this;
        }

        public Criteria andEmailid4LessThan(Integer value) {
            addCriterion("emailid4 <", value, "emailid4");
            return (Criteria) this;
        }

        public Criteria andEmailid4LessThanOrEqualTo(Integer value) {
            addCriterion("emailid4 <=", value, "emailid4");
            return (Criteria) this;
        }

        public Criteria andEmailid4In(List<Integer> values) {
            addCriterion("emailid4 in", values, "emailid4");
            return (Criteria) this;
        }

        public Criteria andEmailid4NotIn(List<Integer> values) {
            addCriterion("emailid4 not in", values, "emailid4");
            return (Criteria) this;
        }

        public Criteria andEmailid4Between(Integer value1, Integer value2) {
            addCriterion("emailid4 between", value1, value2, "emailid4");
            return (Criteria) this;
        }

        public Criteria andEmailid4NotBetween(Integer value1, Integer value2) {
            addCriterion("emailid4 not between", value1, value2, "emailid4");
            return (Criteria) this;
        }

        public Criteria andEmailid5IsNull() {
            addCriterion("emailid5 is null");
            return (Criteria) this;
        }

        public Criteria andEmailid5IsNotNull() {
            addCriterion("emailid5 is not null");
            return (Criteria) this;
        }

        public Criteria andEmailid5EqualTo(Integer value) {
            addCriterion("emailid5 =", value, "emailid5");
            return (Criteria) this;
        }

        public Criteria andEmailid5NotEqualTo(Integer value) {
            addCriterion("emailid5 <>", value, "emailid5");
            return (Criteria) this;
        }

        public Criteria andEmailid5GreaterThan(Integer value) {
            addCriterion("emailid5 >", value, "emailid5");
            return (Criteria) this;
        }

        public Criteria andEmailid5GreaterThanOrEqualTo(Integer value) {
            addCriterion("emailid5 >=", value, "emailid5");
            return (Criteria) this;
        }

        public Criteria andEmailid5LessThan(Integer value) {
            addCriterion("emailid5 <", value, "emailid5");
            return (Criteria) this;
        }

        public Criteria andEmailid5LessThanOrEqualTo(Integer value) {
            addCriterion("emailid5 <=", value, "emailid5");
            return (Criteria) this;
        }

        public Criteria andEmailid5In(List<Integer> values) {
            addCriterion("emailid5 in", values, "emailid5");
            return (Criteria) this;
        }

        public Criteria andEmailid5NotIn(List<Integer> values) {
            addCriterion("emailid5 not in", values, "emailid5");
            return (Criteria) this;
        }

        public Criteria andEmailid5Between(Integer value1, Integer value2) {
            addCriterion("emailid5 between", value1, value2, "emailid5");
            return (Criteria) this;
        }

        public Criteria andEmailid5NotBetween(Integer value1, Integer value2) {
            addCriterion("emailid5 not between", value1, value2, "emailid5");
            return (Criteria) this;
        }

        public Criteria andWinnumIsNull() {
            addCriterion("winnum is null");
            return (Criteria) this;
        }

        public Criteria andWinnumIsNotNull() {
            addCriterion("winnum is not null");
            return (Criteria) this;
        }

        public Criteria andWinnumEqualTo(Integer value) {
            addCriterion("winnum =", value, "winnum");
            return (Criteria) this;
        }

        public Criteria andWinnumNotEqualTo(Integer value) {
            addCriterion("winnum <>", value, "winnum");
            return (Criteria) this;
        }

        public Criteria andWinnumGreaterThan(Integer value) {
            addCriterion("winnum >", value, "winnum");
            return (Criteria) this;
        }

        public Criteria andWinnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("winnum >=", value, "winnum");
            return (Criteria) this;
        }

        public Criteria andWinnumLessThan(Integer value) {
            addCriterion("winnum <", value, "winnum");
            return (Criteria) this;
        }

        public Criteria andWinnumLessThanOrEqualTo(Integer value) {
            addCriterion("winnum <=", value, "winnum");
            return (Criteria) this;
        }

        public Criteria andWinnumIn(List<Integer> values) {
            addCriterion("winnum in", values, "winnum");
            return (Criteria) this;
        }

        public Criteria andWinnumNotIn(List<Integer> values) {
            addCriterion("winnum not in", values, "winnum");
            return (Criteria) this;
        }

        public Criteria andWinnumBetween(Integer value1, Integer value2) {
            addCriterion("winnum between", value1, value2, "winnum");
            return (Criteria) this;
        }

        public Criteria andWinnumNotBetween(Integer value1, Integer value2) {
            addCriterion("winnum not between", value1, value2, "winnum");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}