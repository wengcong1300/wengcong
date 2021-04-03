package cn.qziedu.game.pojo;

import java.util.ArrayList;
import java.util.List;

public class BaominginfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaominginfoExample() {
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

        public Criteria andEmailidIsNull() {
            addCriterion("emailid is null");
            return (Criteria) this;
        }

        public Criteria andEmailidIsNotNull() {
            addCriterion("emailid is not null");
            return (Criteria) this;
        }

        public Criteria andEmailidEqualTo(Integer value) {
            addCriterion("emailid =", value, "emailid");
            return (Criteria) this;
        }

        public Criteria andEmailidNotEqualTo(Integer value) {
            addCriterion("emailid <>", value, "emailid");
            return (Criteria) this;
        }

        public Criteria andEmailidGreaterThan(Integer value) {
            addCriterion("emailid >", value, "emailid");
            return (Criteria) this;
        }

        public Criteria andEmailidGreaterThanOrEqualTo(Integer value) {
            addCriterion("emailid >=", value, "emailid");
            return (Criteria) this;
        }

        public Criteria andEmailidLessThan(Integer value) {
            addCriterion("emailid <", value, "emailid");
            return (Criteria) this;
        }

        public Criteria andEmailidLessThanOrEqualTo(Integer value) {
            addCriterion("emailid <=", value, "emailid");
            return (Criteria) this;
        }

        public Criteria andEmailidIn(List<Integer> values) {
            addCriterion("emailid in", values, "emailid");
            return (Criteria) this;
        }

        public Criteria andEmailidNotIn(List<Integer> values) {
            addCriterion("emailid not in", values, "emailid");
            return (Criteria) this;
        }

        public Criteria andEmailidBetween(Integer value1, Integer value2) {
            addCriterion("emailid between", value1, value2, "emailid");
            return (Criteria) this;
        }

        public Criteria andEmailidNotBetween(Integer value1, Integer value2) {
            addCriterion("emailid not between", value1, value2, "emailid");
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

        public Criteria andNumwinIsNull() {
            addCriterion("numwin is null");
            return (Criteria) this;
        }

        public Criteria andNumwinIsNotNull() {
            addCriterion("numwin is not null");
            return (Criteria) this;
        }

        public Criteria andNumwinEqualTo(Integer value) {
            addCriterion("numwin =", value, "numwin");
            return (Criteria) this;
        }

        public Criteria andNumwinNotEqualTo(Integer value) {
            addCriterion("numwin <>", value, "numwin");
            return (Criteria) this;
        }

        public Criteria andNumwinGreaterThan(Integer value) {
            addCriterion("numwin >", value, "numwin");
            return (Criteria) this;
        }

        public Criteria andNumwinGreaterThanOrEqualTo(Integer value) {
            addCriterion("numwin >=", value, "numwin");
            return (Criteria) this;
        }

        public Criteria andNumwinLessThan(Integer value) {
            addCriterion("numwin <", value, "numwin");
            return (Criteria) this;
        }

        public Criteria andNumwinLessThanOrEqualTo(Integer value) {
            addCriterion("numwin <=", value, "numwin");
            return (Criteria) this;
        }

        public Criteria andNumwinIn(List<Integer> values) {
            addCriterion("numwin in", values, "numwin");
            return (Criteria) this;
        }

        public Criteria andNumwinNotIn(List<Integer> values) {
            addCriterion("numwin not in", values, "numwin");
            return (Criteria) this;
        }

        public Criteria andNumwinBetween(Integer value1, Integer value2) {
            addCriterion("numwin between", value1, value2, "numwin");
            return (Criteria) this;
        }

        public Criteria andNumwinNotBetween(Integer value1, Integer value2) {
            addCriterion("numwin not between", value1, value2, "numwin");
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