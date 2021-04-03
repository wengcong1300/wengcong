package cn.qziedu.game.pojo;

import java.util.ArrayList;
import java.util.List;

public class BuildinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BuildinfoExample() {
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

        public Criteria andBuildidIsNull() {
            addCriterion("buildid is null");
            return (Criteria) this;
        }

        public Criteria andBuildidIsNotNull() {
            addCriterion("buildid is not null");
            return (Criteria) this;
        }

        public Criteria andBuildidEqualTo(Integer value) {
            addCriterion("buildid =", value, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidNotEqualTo(Integer value) {
            addCriterion("buildid <>", value, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidGreaterThan(Integer value) {
            addCriterion("buildid >", value, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidGreaterThanOrEqualTo(Integer value) {
            addCriterion("buildid >=", value, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidLessThan(Integer value) {
            addCriterion("buildid <", value, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidLessThanOrEqualTo(Integer value) {
            addCriterion("buildid <=", value, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidIn(List<Integer> values) {
            addCriterion("buildid in", values, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidNotIn(List<Integer> values) {
            addCriterion("buildid not in", values, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidBetween(Integer value1, Integer value2) {
            addCriterion("buildid between", value1, value2, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidNotBetween(Integer value1, Integer value2) {
            addCriterion("buildid not between", value1, value2, "buildid");
            return (Criteria) this;
        }

        public Criteria andGamenameIsNull() {
            addCriterion("gamename is null");
            return (Criteria) this;
        }

        public Criteria andGamenameIsNotNull() {
            addCriterion("gamename is not null");
            return (Criteria) this;
        }

        public Criteria andGamenameEqualTo(String value) {
            addCriterion("gamename =", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotEqualTo(String value) {
            addCriterion("gamename <>", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameGreaterThan(String value) {
            addCriterion("gamename >", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameGreaterThanOrEqualTo(String value) {
            addCriterion("gamename >=", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameLessThan(String value) {
            addCriterion("gamename <", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameLessThanOrEqualTo(String value) {
            addCriterion("gamename <=", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameLike(String value) {
            addCriterion("gamename like", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotLike(String value) {
            addCriterion("gamename not like", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameIn(List<String> values) {
            addCriterion("gamename in", values, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotIn(List<String> values) {
            addCriterion("gamename not in", values, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameBetween(String value1, String value2) {
            addCriterion("gamename between", value1, value2, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotBetween(String value1, String value2) {
            addCriterion("gamename not between", value1, value2, "gamename");
            return (Criteria) this;
        }

        public Criteria andMiaoshuIsNull() {
            addCriterion("miaoshu is null");
            return (Criteria) this;
        }

        public Criteria andMiaoshuIsNotNull() {
            addCriterion("miaoshu is not null");
            return (Criteria) this;
        }

        public Criteria andMiaoshuEqualTo(String value) {
            addCriterion("miaoshu =", value, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuNotEqualTo(String value) {
            addCriterion("miaoshu <>", value, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuGreaterThan(String value) {
            addCriterion("miaoshu >", value, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuGreaterThanOrEqualTo(String value) {
            addCriterion("miaoshu >=", value, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuLessThan(String value) {
            addCriterion("miaoshu <", value, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuLessThanOrEqualTo(String value) {
            addCriterion("miaoshu <=", value, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuLike(String value) {
            addCriterion("miaoshu like", value, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuNotLike(String value) {
            addCriterion("miaoshu not like", value, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuIn(List<String> values) {
            addCriterion("miaoshu in", values, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuNotIn(List<String> values) {
            addCriterion("miaoshu not in", values, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuBetween(String value1, String value2) {
            addCriterion("miaoshu between", value1, value2, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuNotBetween(String value1, String value2) {
            addCriterion("miaoshu not between", value1, value2, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andGuizeIsNull() {
            addCriterion("guize is null");
            return (Criteria) this;
        }

        public Criteria andGuizeIsNotNull() {
            addCriterion("guize is not null");
            return (Criteria) this;
        }

        public Criteria andGuizeEqualTo(String value) {
            addCriterion("guize =", value, "guize");
            return (Criteria) this;
        }

        public Criteria andGuizeNotEqualTo(String value) {
            addCriterion("guize <>", value, "guize");
            return (Criteria) this;
        }

        public Criteria andGuizeGreaterThan(String value) {
            addCriterion("guize >", value, "guize");
            return (Criteria) this;
        }

        public Criteria andGuizeGreaterThanOrEqualTo(String value) {
            addCriterion("guize >=", value, "guize");
            return (Criteria) this;
        }

        public Criteria andGuizeLessThan(String value) {
            addCriterion("guize <", value, "guize");
            return (Criteria) this;
        }

        public Criteria andGuizeLessThanOrEqualTo(String value) {
            addCriterion("guize <=", value, "guize");
            return (Criteria) this;
        }

        public Criteria andGuizeLike(String value) {
            addCriterion("guize like", value, "guize");
            return (Criteria) this;
        }

        public Criteria andGuizeNotLike(String value) {
            addCriterion("guize not like", value, "guize");
            return (Criteria) this;
        }

        public Criteria andGuizeIn(List<String> values) {
            addCriterion("guize in", values, "guize");
            return (Criteria) this;
        }

        public Criteria andGuizeNotIn(List<String> values) {
            addCriterion("guize not in", values, "guize");
            return (Criteria) this;
        }

        public Criteria andGuizeBetween(String value1, String value2) {
            addCriterion("guize between", value1, value2, "guize");
            return (Criteria) this;
        }

        public Criteria andGuizeNotBetween(String value1, String value2) {
            addCriterion("guize not between", value1, value2, "guize");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
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