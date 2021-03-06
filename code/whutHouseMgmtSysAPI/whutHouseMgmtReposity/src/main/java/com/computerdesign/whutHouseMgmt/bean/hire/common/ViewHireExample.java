package com.computerdesign.whutHouseMgmt.bean.hire.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ViewHireExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewHireExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNull() {
            addCriterion("StaffId is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("StaffId is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(Integer value) {
            addCriterion("StaffId =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(Integer value) {
            addCriterion("StaffId <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(Integer value) {
            addCriterion("StaffId >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffId >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(Integer value) {
            addCriterion("StaffId <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(Integer value) {
            addCriterion("StaffId <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<Integer> values) {
            addCriterion("StaffId in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<Integer> values) {
            addCriterion("StaffId not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(Integer value1, Integer value2) {
            addCriterion("StaffId between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffId not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffNoIsNull() {
            addCriterion("StaffNo is null");
            return (Criteria) this;
        }

        public Criteria andStaffNoIsNotNull() {
            addCriterion("StaffNo is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNoEqualTo(String value) {
            addCriterion("StaffNo =", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotEqualTo(String value) {
            addCriterion("StaffNo <>", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoGreaterThan(String value) {
            addCriterion("StaffNo >", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoGreaterThanOrEqualTo(String value) {
            addCriterion("StaffNo >=", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoLessThan(String value) {
            addCriterion("StaffNo <", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoLessThanOrEqualTo(String value) {
            addCriterion("StaffNo <=", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoLike(String value) {
            addCriterion("StaffNo like", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotLike(String value) {
            addCriterion("StaffNo not like", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoIn(List<String> values) {
            addCriterion("StaffNo in", values, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotIn(List<String> values) {
            addCriterion("StaffNo not in", values, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoBetween(String value1, String value2) {
            addCriterion("StaffNo between", value1, value2, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotBetween(String value1, String value2) {
            addCriterion("StaffNo not between", value1, value2, "staffNo");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("Name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("Name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("Name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("Name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("Name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("Name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("Name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("Name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("Name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("Sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("Sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("Sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("Sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("Sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("Sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("Sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("Sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("Sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("Sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("Sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("Sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("Sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("Sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andTitleNameIsNull() {
            addCriterion("TitleName is null");
            return (Criteria) this;
        }

        public Criteria andTitleNameIsNotNull() {
            addCriterion("TitleName is not null");
            return (Criteria) this;
        }

        public Criteria andTitleNameEqualTo(String value) {
            addCriterion("TitleName =", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotEqualTo(String value) {
            addCriterion("TitleName <>", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameGreaterThan(String value) {
            addCriterion("TitleName >", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameGreaterThanOrEqualTo(String value) {
            addCriterion("TitleName >=", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameLessThan(String value) {
            addCriterion("TitleName <", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameLessThanOrEqualTo(String value) {
            addCriterion("TitleName <=", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameLike(String value) {
            addCriterion("TitleName like", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotLike(String value) {
            addCriterion("TitleName not like", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameIn(List<String> values) {
            addCriterion("TitleName in", values, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotIn(List<String> values) {
            addCriterion("TitleName not in", values, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameBetween(String value1, String value2) {
            addCriterion("TitleName between", value1, value2, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotBetween(String value1, String value2) {
            addCriterion("TitleName not between", value1, value2, "titleName");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValIsNull() {
            addCriterion("SpouseTitleVal is null");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValIsNotNull() {
            addCriterion("SpouseTitleVal is not null");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValEqualTo(Integer value) {
            addCriterion("SpouseTitleVal =", value, "spouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValNotEqualTo(Integer value) {
            addCriterion("SpouseTitleVal <>", value, "spouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValGreaterThan(Integer value) {
            addCriterion("SpouseTitleVal >", value, "spouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValGreaterThanOrEqualTo(Integer value) {
            addCriterion("SpouseTitleVal >=", value, "spouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValLessThan(Integer value) {
            addCriterion("SpouseTitleVal <", value, "spouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValLessThanOrEqualTo(Integer value) {
            addCriterion("SpouseTitleVal <=", value, "spouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValIn(List<Integer> values) {
            addCriterion("SpouseTitleVal in", values, "spouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValNotIn(List<Integer> values) {
            addCriterion("SpouseTitleVal not in", values, "spouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValBetween(Integer value1, Integer value2) {
            addCriterion("SpouseTitleVal between", value1, value2, "spouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValNotBetween(Integer value1, Integer value2) {
            addCriterion("SpouseTitleVal not between", value1, value2, "spouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andPostNameIsNull() {
            addCriterion("PostName is null");
            return (Criteria) this;
        }

        public Criteria andPostNameIsNotNull() {
            addCriterion("PostName is not null");
            return (Criteria) this;
        }

        public Criteria andPostNameEqualTo(String value) {
            addCriterion("PostName =", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotEqualTo(String value) {
            addCriterion("PostName <>", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameGreaterThan(String value) {
            addCriterion("PostName >", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameGreaterThanOrEqualTo(String value) {
            addCriterion("PostName >=", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameLessThan(String value) {
            addCriterion("PostName <", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameLessThanOrEqualTo(String value) {
            addCriterion("PostName <=", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameLike(String value) {
            addCriterion("PostName like", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotLike(String value) {
            addCriterion("PostName not like", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameIn(List<String> values) {
            addCriterion("PostName in", values, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotIn(List<String> values) {
            addCriterion("PostName not in", values, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameBetween(String value1, String value2) {
            addCriterion("PostName between", value1, value2, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotBetween(String value1, String value2) {
            addCriterion("PostName not between", value1, value2, "postName");
            return (Criteria) this;
        }

        public Criteria andSpousePostValIsNull() {
            addCriterion("SpousePostVal is null");
            return (Criteria) this;
        }

        public Criteria andSpousePostValIsNotNull() {
            addCriterion("SpousePostVal is not null");
            return (Criteria) this;
        }

        public Criteria andSpousePostValEqualTo(Integer value) {
            addCriterion("SpousePostVal =", value, "spousePostVal");
            return (Criteria) this;
        }

        public Criteria andSpousePostValNotEqualTo(Integer value) {
            addCriterion("SpousePostVal <>", value, "spousePostVal");
            return (Criteria) this;
        }

        public Criteria andSpousePostValGreaterThan(Integer value) {
            addCriterion("SpousePostVal >", value, "spousePostVal");
            return (Criteria) this;
        }

        public Criteria andSpousePostValGreaterThanOrEqualTo(Integer value) {
            addCriterion("SpousePostVal >=", value, "spousePostVal");
            return (Criteria) this;
        }

        public Criteria andSpousePostValLessThan(Integer value) {
            addCriterion("SpousePostVal <", value, "spousePostVal");
            return (Criteria) this;
        }

        public Criteria andSpousePostValLessThanOrEqualTo(Integer value) {
            addCriterion("SpousePostVal <=", value, "spousePostVal");
            return (Criteria) this;
        }

        public Criteria andSpousePostValIn(List<Integer> values) {
            addCriterion("SpousePostVal in", values, "spousePostVal");
            return (Criteria) this;
        }

        public Criteria andSpousePostValNotIn(List<Integer> values) {
            addCriterion("SpousePostVal not in", values, "spousePostVal");
            return (Criteria) this;
        }

        public Criteria andSpousePostValBetween(Integer value1, Integer value2) {
            addCriterion("SpousePostVal between", value1, value2, "spousePostVal");
            return (Criteria) this;
        }

        public Criteria andSpousePostValNotBetween(Integer value1, Integer value2) {
            addCriterion("SpousePostVal not between", value1, value2, "spousePostVal");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("TypeName is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("TypeName is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("TypeName =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("TypeName <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("TypeName >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("TypeName >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("TypeName <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("TypeName <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("TypeName like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("TypeName not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("TypeName in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("TypeName not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("TypeName between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("TypeName not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNull() {
            addCriterion("DeptName is null");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNotNull() {
            addCriterion("DeptName is not null");
            return (Criteria) this;
        }

        public Criteria andDeptNameEqualTo(String value) {
            addCriterion("DeptName =", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotEqualTo(String value) {
            addCriterion("DeptName <>", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThan(String value) {
            addCriterion("DeptName >", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("DeptName >=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThan(String value) {
            addCriterion("DeptName <", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThanOrEqualTo(String value) {
            addCriterion("DeptName <=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLike(String value) {
            addCriterion("DeptName like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotLike(String value) {
            addCriterion("DeptName not like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameIn(List<String> values) {
            addCriterion("DeptName in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotIn(List<String> values) {
            addCriterion("DeptName not in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameBetween(String value1, String value2) {
            addCriterion("DeptName between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotBetween(String value1, String value2) {
            addCriterion("DeptName not between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andHouseIdIsNull() {
            addCriterion("HouseId is null");
            return (Criteria) this;
        }

        public Criteria andHouseIdIsNotNull() {
            addCriterion("HouseId is not null");
            return (Criteria) this;
        }

        public Criteria andHouseIdEqualTo(Integer value) {
            addCriterion("HouseId =", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotEqualTo(Integer value) {
            addCriterion("HouseId <>", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThan(Integer value) {
            addCriterion("HouseId >", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HouseId >=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThan(Integer value) {
            addCriterion("HouseId <", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThanOrEqualTo(Integer value) {
            addCriterion("HouseId <=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdIn(List<Integer> values) {
            addCriterion("HouseId in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotIn(List<Integer> values) {
            addCriterion("HouseId not in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdBetween(Integer value1, Integer value2) {
            addCriterion("HouseId between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HouseId not between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseNoIsNull() {
            addCriterion("HouseNo is null");
            return (Criteria) this;
        }

        public Criteria andHouseNoIsNotNull() {
            addCriterion("HouseNo is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNoEqualTo(String value) {
            addCriterion("HouseNo =", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotEqualTo(String value) {
            addCriterion("HouseNo <>", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoGreaterThan(String value) {
            addCriterion("HouseNo >", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoGreaterThanOrEqualTo(String value) {
            addCriterion("HouseNo >=", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLessThan(String value) {
            addCriterion("HouseNo <", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLessThanOrEqualTo(String value) {
            addCriterion("HouseNo <=", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLike(String value) {
            addCriterion("HouseNo like", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotLike(String value) {
            addCriterion("HouseNo not like", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoIn(List<String> values) {
            addCriterion("HouseNo in", values, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotIn(List<String> values) {
            addCriterion("HouseNo not in", values, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoBetween(String value1, String value2) {
            addCriterion("HouseNo between", value1, value2, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotBetween(String value1, String value2) {
            addCriterion("HouseNo not between", value1, value2, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaIsNull() {
            addCriterion("HouseBuildArea is null");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaIsNotNull() {
            addCriterion("HouseBuildArea is not null");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaEqualTo(Double value) {
            addCriterion("HouseBuildArea =", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaNotEqualTo(Double value) {
            addCriterion("HouseBuildArea <>", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaGreaterThan(Double value) {
            addCriterion("HouseBuildArea >", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("HouseBuildArea >=", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaLessThan(Double value) {
            addCriterion("HouseBuildArea <", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaLessThanOrEqualTo(Double value) {
            addCriterion("HouseBuildArea <=", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaIn(List<Double> values) {
            addCriterion("HouseBuildArea in", values, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaNotIn(List<Double> values) {
            addCriterion("HouseBuildArea not in", values, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaBetween(Double value1, Double value2) {
            addCriterion("HouseBuildArea between", value1, value2, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaNotBetween(Double value1, Double value2) {
            addCriterion("HouseBuildArea not between", value1, value2, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseUserAreaIsNull() {
            addCriterion("HouseUserArea is null");
            return (Criteria) this;
        }

        public Criteria andHouseUserAreaIsNotNull() {
            addCriterion("HouseUserArea is not null");
            return (Criteria) this;
        }

        public Criteria andHouseUserAreaEqualTo(Double value) {
            addCriterion("HouseUserArea =", value, "houseUserArea");
            return (Criteria) this;
        }

        public Criteria andHouseUserAreaNotEqualTo(Double value) {
            addCriterion("HouseUserArea <>", value, "houseUserArea");
            return (Criteria) this;
        }

        public Criteria andHouseUserAreaGreaterThan(Double value) {
            addCriterion("HouseUserArea >", value, "houseUserArea");
            return (Criteria) this;
        }

        public Criteria andHouseUserAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("HouseUserArea >=", value, "houseUserArea");
            return (Criteria) this;
        }

        public Criteria andHouseUserAreaLessThan(Double value) {
            addCriterion("HouseUserArea <", value, "houseUserArea");
            return (Criteria) this;
        }

        public Criteria andHouseUserAreaLessThanOrEqualTo(Double value) {
            addCriterion("HouseUserArea <=", value, "houseUserArea");
            return (Criteria) this;
        }

        public Criteria andHouseUserAreaIn(List<Double> values) {
            addCriterion("HouseUserArea in", values, "houseUserArea");
            return (Criteria) this;
        }

        public Criteria andHouseUserAreaNotIn(List<Double> values) {
            addCriterion("HouseUserArea not in", values, "houseUserArea");
            return (Criteria) this;
        }

        public Criteria andHouseUserAreaBetween(Double value1, Double value2) {
            addCriterion("HouseUserArea between", value1, value2, "houseUserArea");
            return (Criteria) this;
        }

        public Criteria andHouseUserAreaNotBetween(Double value1, Double value2) {
            addCriterion("HouseUserArea not between", value1, value2, "houseUserArea");
            return (Criteria) this;
        }

        public Criteria andHouseAddressIsNull() {
            addCriterion("HouseAddress is null");
            return (Criteria) this;
        }

        public Criteria andHouseAddressIsNotNull() {
            addCriterion("HouseAddress is not null");
            return (Criteria) this;
        }

        public Criteria andHouseAddressEqualTo(String value) {
            addCriterion("HouseAddress =", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressNotEqualTo(String value) {
            addCriterion("HouseAddress <>", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressGreaterThan(String value) {
            addCriterion("HouseAddress >", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressGreaterThanOrEqualTo(String value) {
            addCriterion("HouseAddress >=", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressLessThan(String value) {
            addCriterion("HouseAddress <", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressLessThanOrEqualTo(String value) {
            addCriterion("HouseAddress <=", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressLike(String value) {
            addCriterion("HouseAddress like", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressNotLike(String value) {
            addCriterion("HouseAddress not like", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressIn(List<String> values) {
            addCriterion("HouseAddress in", values, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressNotIn(List<String> values) {
            addCriterion("HouseAddress not in", values, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressBetween(String value1, String value2) {
            addCriterion("HouseAddress between", value1, value2, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressNotBetween(String value1, String value2) {
            addCriterion("HouseAddress not between", value1, value2, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("ApplyTime is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("ApplyTime is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Date value) {
            addCriterionForJDBCDate("ApplyTime =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ApplyTime <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ApplyTime >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ApplyTime >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Date value) {
            addCriterionForJDBCDate("ApplyTime <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ApplyTime <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<Date> values) {
            addCriterionForJDBCDate("ApplyTime in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ApplyTime not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ApplyTime between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ApplyTime not between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("Reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("Reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("Reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("Reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("Reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("Reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("Reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("Reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("Reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("Reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("Reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("Reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("Reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("Reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("Phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("Phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("Phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("Phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("Phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("Phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("Phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("Phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("Phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("Phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("Phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("Phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("Phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("Phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andHireStateIsNull() {
            addCriterion("HireState is null");
            return (Criteria) this;
        }

        public Criteria andHireStateIsNotNull() {
            addCriterion("HireState is not null");
            return (Criteria) this;
        }

        public Criteria andHireStateEqualTo(String value) {
            addCriterion("HireState =", value, "hireState");
            return (Criteria) this;
        }

        public Criteria andHireStateNotEqualTo(String value) {
            addCriterion("HireState <>", value, "hireState");
            return (Criteria) this;
        }

        public Criteria andHireStateGreaterThan(String value) {
            addCriterion("HireState >", value, "hireState");
            return (Criteria) this;
        }

        public Criteria andHireStateGreaterThanOrEqualTo(String value) {
            addCriterion("HireState >=", value, "hireState");
            return (Criteria) this;
        }

        public Criteria andHireStateLessThan(String value) {
            addCriterion("HireState <", value, "hireState");
            return (Criteria) this;
        }

        public Criteria andHireStateLessThanOrEqualTo(String value) {
            addCriterion("HireState <=", value, "hireState");
            return (Criteria) this;
        }

        public Criteria andHireStateLike(String value) {
            addCriterion("HireState like", value, "hireState");
            return (Criteria) this;
        }

        public Criteria andHireStateNotLike(String value) {
            addCriterion("HireState not like", value, "hireState");
            return (Criteria) this;
        }

        public Criteria andHireStateIn(List<String> values) {
            addCriterion("HireState in", values, "hireState");
            return (Criteria) this;
        }

        public Criteria andHireStateNotIn(List<String> values) {
            addCriterion("HireState not in", values, "hireState");
            return (Criteria) this;
        }

        public Criteria andHireStateBetween(String value1, String value2) {
            addCriterion("HireState between", value1, value2, "hireState");
            return (Criteria) this;
        }

        public Criteria andHireStateNotBetween(String value1, String value2) {
            addCriterion("HireState not between", value1, value2, "hireState");
            return (Criteria) this;
        }

        public Criteria andTitleValIsNull() {
            addCriterion("TitleVal is null");
            return (Criteria) this;
        }

        public Criteria andTitleValIsNotNull() {
            addCriterion("TitleVal is not null");
            return (Criteria) this;
        }

        public Criteria andTitleValEqualTo(Double value) {
            addCriterion("TitleVal =", value, "titleVal");
            return (Criteria) this;
        }

        public Criteria andTitleValNotEqualTo(Double value) {
            addCriterion("TitleVal <>", value, "titleVal");
            return (Criteria) this;
        }

        public Criteria andTitleValGreaterThan(Double value) {
            addCriterion("TitleVal >", value, "titleVal");
            return (Criteria) this;
        }

        public Criteria andTitleValGreaterThanOrEqualTo(Double value) {
            addCriterion("TitleVal >=", value, "titleVal");
            return (Criteria) this;
        }

        public Criteria andTitleValLessThan(Double value) {
            addCriterion("TitleVal <", value, "titleVal");
            return (Criteria) this;
        }

        public Criteria andTitleValLessThanOrEqualTo(Double value) {
            addCriterion("TitleVal <=", value, "titleVal");
            return (Criteria) this;
        }

        public Criteria andTitleValIn(List<Double> values) {
            addCriterion("TitleVal in", values, "titleVal");
            return (Criteria) this;
        }

        public Criteria andTitleValNotIn(List<Double> values) {
            addCriterion("TitleVal not in", values, "titleVal");
            return (Criteria) this;
        }

        public Criteria andTitleValBetween(Double value1, Double value2) {
            addCriterion("TitleVal between", value1, value2, "titleVal");
            return (Criteria) this;
        }

        public Criteria andTitleValNotBetween(Double value1, Double value2) {
            addCriterion("TitleVal not between", value1, value2, "titleVal");
            return (Criteria) this;
        }

        public Criteria andTotalValIsNull() {
            addCriterion("TotalVal is null");
            return (Criteria) this;
        }

        public Criteria andTotalValIsNotNull() {
            addCriterion("TotalVal is not null");
            return (Criteria) this;
        }

        public Criteria andTotalValEqualTo(Double value) {
            addCriterion("TotalVal =", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValNotEqualTo(Double value) {
            addCriterion("TotalVal <>", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValGreaterThan(Double value) {
            addCriterion("TotalVal >", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValGreaterThanOrEqualTo(Double value) {
            addCriterion("TotalVal >=", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValLessThan(Double value) {
            addCriterion("TotalVal <", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValLessThanOrEqualTo(Double value) {
            addCriterion("TotalVal <=", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValIn(List<Double> values) {
            addCriterion("TotalVal in", values, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValNotIn(List<Double> values) {
            addCriterion("TotalVal not in", values, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValBetween(Double value1, Double value2) {
            addCriterion("TotalVal between", value1, value2, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValNotBetween(Double value1, Double value2) {
            addCriterion("TotalVal not between", value1, value2, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTimeValIsNull() {
            addCriterion("TimeVal is null");
            return (Criteria) this;
        }

        public Criteria andTimeValIsNotNull() {
            addCriterion("TimeVal is not null");
            return (Criteria) this;
        }

        public Criteria andTimeValEqualTo(Double value) {
            addCriterion("TimeVal =", value, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValNotEqualTo(Double value) {
            addCriterion("TimeVal <>", value, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValGreaterThan(Double value) {
            addCriterion("TimeVal >", value, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValGreaterThanOrEqualTo(Double value) {
            addCriterion("TimeVal >=", value, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValLessThan(Double value) {
            addCriterion("TimeVal <", value, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValLessThanOrEqualTo(Double value) {
            addCriterion("TimeVal <=", value, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValIn(List<Double> values) {
            addCriterion("TimeVal in", values, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValNotIn(List<Double> values) {
            addCriterion("TimeVal not in", values, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValBetween(Double value1, Double value2) {
            addCriterion("TimeVal between", value1, value2, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValNotBetween(Double value1, Double value2) {
            addCriterion("TimeVal not between", value1, value2, "timeVal");
            return (Criteria) this;
        }

        public Criteria andSpouseValIsNull() {
            addCriterion("SpouseVal is null");
            return (Criteria) this;
        }

        public Criteria andSpouseValIsNotNull() {
            addCriterion("SpouseVal is not null");
            return (Criteria) this;
        }

        public Criteria andSpouseValEqualTo(Double value) {
            addCriterion("SpouseVal =", value, "spouseVal");
            return (Criteria) this;
        }

        public Criteria andSpouseValNotEqualTo(Double value) {
            addCriterion("SpouseVal <>", value, "spouseVal");
            return (Criteria) this;
        }

        public Criteria andSpouseValGreaterThan(Double value) {
            addCriterion("SpouseVal >", value, "spouseVal");
            return (Criteria) this;
        }

        public Criteria andSpouseValGreaterThanOrEqualTo(Double value) {
            addCriterion("SpouseVal >=", value, "spouseVal");
            return (Criteria) this;
        }

        public Criteria andSpouseValLessThan(Double value) {
            addCriterion("SpouseVal <", value, "spouseVal");
            return (Criteria) this;
        }

        public Criteria andSpouseValLessThanOrEqualTo(Double value) {
            addCriterion("SpouseVal <=", value, "spouseVal");
            return (Criteria) this;
        }

        public Criteria andSpouseValIn(List<Double> values) {
            addCriterion("SpouseVal in", values, "spouseVal");
            return (Criteria) this;
        }

        public Criteria andSpouseValNotIn(List<Double> values) {
            addCriterion("SpouseVal not in", values, "spouseVal");
            return (Criteria) this;
        }

        public Criteria andSpouseValBetween(Double value1, Double value2) {
            addCriterion("SpouseVal between", value1, value2, "spouseVal");
            return (Criteria) this;
        }

        public Criteria andSpouseValNotBetween(Double value1, Double value2) {
            addCriterion("SpouseVal not between", value1, value2, "spouseVal");
            return (Criteria) this;
        }

        public Criteria andOtherValIsNull() {
            addCriterion("OtherVal is null");
            return (Criteria) this;
        }

        public Criteria andOtherValIsNotNull() {
            addCriterion("OtherVal is not null");
            return (Criteria) this;
        }

        public Criteria andOtherValEqualTo(Double value) {
            addCriterion("OtherVal =", value, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValNotEqualTo(Double value) {
            addCriterion("OtherVal <>", value, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValGreaterThan(Double value) {
            addCriterion("OtherVal >", value, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValGreaterThanOrEqualTo(Double value) {
            addCriterion("OtherVal >=", value, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValLessThan(Double value) {
            addCriterion("OtherVal <", value, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValLessThanOrEqualTo(Double value) {
            addCriterion("OtherVal <=", value, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValIn(List<Double> values) {
            addCriterion("OtherVal in", values, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValNotIn(List<Double> values) {
            addCriterion("OtherVal not in", values, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValBetween(Double value1, Double value2) {
            addCriterion("OtherVal between", value1, value2, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValNotBetween(Double value1, Double value2) {
            addCriterion("OtherVal not between", value1, value2, "otherVal");
            return (Criteria) this;
        }

        public Criteria andAcceptNoteIsNull() {
            addCriterion("AcceptNote is null");
            return (Criteria) this;
        }

        public Criteria andAcceptNoteIsNotNull() {
            addCriterion("AcceptNote is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptNoteEqualTo(String value) {
            addCriterion("AcceptNote =", value, "acceptNote");
            return (Criteria) this;
        }

        public Criteria andAcceptNoteNotEqualTo(String value) {
            addCriterion("AcceptNote <>", value, "acceptNote");
            return (Criteria) this;
        }

        public Criteria andAcceptNoteGreaterThan(String value) {
            addCriterion("AcceptNote >", value, "acceptNote");
            return (Criteria) this;
        }

        public Criteria andAcceptNoteGreaterThanOrEqualTo(String value) {
            addCriterion("AcceptNote >=", value, "acceptNote");
            return (Criteria) this;
        }

        public Criteria andAcceptNoteLessThan(String value) {
            addCriterion("AcceptNote <", value, "acceptNote");
            return (Criteria) this;
        }

        public Criteria andAcceptNoteLessThanOrEqualTo(String value) {
            addCriterion("AcceptNote <=", value, "acceptNote");
            return (Criteria) this;
        }

        public Criteria andAcceptNoteLike(String value) {
            addCriterion("AcceptNote like", value, "acceptNote");
            return (Criteria) this;
        }

        public Criteria andAcceptNoteNotLike(String value) {
            addCriterion("AcceptNote not like", value, "acceptNote");
            return (Criteria) this;
        }

        public Criteria andAcceptNoteIn(List<String> values) {
            addCriterion("AcceptNote in", values, "acceptNote");
            return (Criteria) this;
        }

        public Criteria andAcceptNoteNotIn(List<String> values) {
            addCriterion("AcceptNote not in", values, "acceptNote");
            return (Criteria) this;
        }

        public Criteria andAcceptNoteBetween(String value1, String value2) {
            addCriterion("AcceptNote between", value1, value2, "acceptNote");
            return (Criteria) this;
        }

        public Criteria andAcceptNoteNotBetween(String value1, String value2) {
            addCriterion("AcceptNote not between", value1, value2, "acceptNote");
            return (Criteria) this;
        }

        public Criteria andAcceptStateIsNull() {
            addCriterion("AcceptState is null");
            return (Criteria) this;
        }

        public Criteria andAcceptStateIsNotNull() {
            addCriterion("AcceptState is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptStateEqualTo(String value) {
            addCriterion("AcceptState =", value, "acceptState");
            return (Criteria) this;
        }

        public Criteria andAcceptStateNotEqualTo(String value) {
            addCriterion("AcceptState <>", value, "acceptState");
            return (Criteria) this;
        }

        public Criteria andAcceptStateGreaterThan(String value) {
            addCriterion("AcceptState >", value, "acceptState");
            return (Criteria) this;
        }

        public Criteria andAcceptStateGreaterThanOrEqualTo(String value) {
            addCriterion("AcceptState >=", value, "acceptState");
            return (Criteria) this;
        }

        public Criteria andAcceptStateLessThan(String value) {
            addCriterion("AcceptState <", value, "acceptState");
            return (Criteria) this;
        }

        public Criteria andAcceptStateLessThanOrEqualTo(String value) {
            addCriterion("AcceptState <=", value, "acceptState");
            return (Criteria) this;
        }

        public Criteria andAcceptStateLike(String value) {
            addCriterion("AcceptState like", value, "acceptState");
            return (Criteria) this;
        }

        public Criteria andAcceptStateNotLike(String value) {
            addCriterion("AcceptState not like", value, "acceptState");
            return (Criteria) this;
        }

        public Criteria andAcceptStateIn(List<String> values) {
            addCriterion("AcceptState in", values, "acceptState");
            return (Criteria) this;
        }

        public Criteria andAcceptStateNotIn(List<String> values) {
            addCriterion("AcceptState not in", values, "acceptState");
            return (Criteria) this;
        }

        public Criteria andAcceptStateBetween(String value1, String value2) {
            addCriterion("AcceptState between", value1, value2, "acceptState");
            return (Criteria) this;
        }

        public Criteria andAcceptStateNotBetween(String value1, String value2) {
            addCriterion("AcceptState not between", value1, value2, "acceptState");
            return (Criteria) this;
        }

        public Criteria andAcceptManIsNull() {
            addCriterion("AcceptMan is null");
            return (Criteria) this;
        }

        public Criteria andAcceptManIsNotNull() {
            addCriterion("AcceptMan is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptManEqualTo(String value) {
            addCriterion("AcceptMan =", value, "acceptMan");
            return (Criteria) this;
        }

        public Criteria andAcceptManNotEqualTo(String value) {
            addCriterion("AcceptMan <>", value, "acceptMan");
            return (Criteria) this;
        }

        public Criteria andAcceptManGreaterThan(String value) {
            addCriterion("AcceptMan >", value, "acceptMan");
            return (Criteria) this;
        }

        public Criteria andAcceptManGreaterThanOrEqualTo(String value) {
            addCriterion("AcceptMan >=", value, "acceptMan");
            return (Criteria) this;
        }

        public Criteria andAcceptManLessThan(String value) {
            addCriterion("AcceptMan <", value, "acceptMan");
            return (Criteria) this;
        }

        public Criteria andAcceptManLessThanOrEqualTo(String value) {
            addCriterion("AcceptMan <=", value, "acceptMan");
            return (Criteria) this;
        }

        public Criteria andAcceptManLike(String value) {
            addCriterion("AcceptMan like", value, "acceptMan");
            return (Criteria) this;
        }

        public Criteria andAcceptManNotLike(String value) {
            addCriterion("AcceptMan not like", value, "acceptMan");
            return (Criteria) this;
        }

        public Criteria andAcceptManIn(List<String> values) {
            addCriterion("AcceptMan in", values, "acceptMan");
            return (Criteria) this;
        }

        public Criteria andAcceptManNotIn(List<String> values) {
            addCriterion("AcceptMan not in", values, "acceptMan");
            return (Criteria) this;
        }

        public Criteria andAcceptManBetween(String value1, String value2) {
            addCriterion("AcceptMan between", value1, value2, "acceptMan");
            return (Criteria) this;
        }

        public Criteria andAcceptManNotBetween(String value1, String value2) {
            addCriterion("AcceptMan not between", value1, value2, "acceptMan");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIsNull() {
            addCriterion("AcceptTime is null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIsNotNull() {
            addCriterion("AcceptTime is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeEqualTo(Date value) {
            addCriterionForJDBCDate("AcceptTime =", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("AcceptTime <>", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("AcceptTime >", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("AcceptTime >=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThan(Date value) {
            addCriterionForJDBCDate("AcceptTime <", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("AcceptTime <=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIn(List<Date> values) {
            addCriterionForJDBCDate("AcceptTime in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("AcceptTime not in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("AcceptTime between", value1, value2, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("AcceptTime not between", value1, value2, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAgreeNoteIsNull() {
            addCriterion("AgreeNote is null");
            return (Criteria) this;
        }

        public Criteria andAgreeNoteIsNotNull() {
            addCriterion("AgreeNote is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeNoteEqualTo(String value) {
            addCriterion("AgreeNote =", value, "agreeNote");
            return (Criteria) this;
        }

        public Criteria andAgreeNoteNotEqualTo(String value) {
            addCriterion("AgreeNote <>", value, "agreeNote");
            return (Criteria) this;
        }

        public Criteria andAgreeNoteGreaterThan(String value) {
            addCriterion("AgreeNote >", value, "agreeNote");
            return (Criteria) this;
        }

        public Criteria andAgreeNoteGreaterThanOrEqualTo(String value) {
            addCriterion("AgreeNote >=", value, "agreeNote");
            return (Criteria) this;
        }

        public Criteria andAgreeNoteLessThan(String value) {
            addCriterion("AgreeNote <", value, "agreeNote");
            return (Criteria) this;
        }

        public Criteria andAgreeNoteLessThanOrEqualTo(String value) {
            addCriterion("AgreeNote <=", value, "agreeNote");
            return (Criteria) this;
        }

        public Criteria andAgreeNoteLike(String value) {
            addCriterion("AgreeNote like", value, "agreeNote");
            return (Criteria) this;
        }

        public Criteria andAgreeNoteNotLike(String value) {
            addCriterion("AgreeNote not like", value, "agreeNote");
            return (Criteria) this;
        }

        public Criteria andAgreeNoteIn(List<String> values) {
            addCriterion("AgreeNote in", values, "agreeNote");
            return (Criteria) this;
        }

        public Criteria andAgreeNoteNotIn(List<String> values) {
            addCriterion("AgreeNote not in", values, "agreeNote");
            return (Criteria) this;
        }

        public Criteria andAgreeNoteBetween(String value1, String value2) {
            addCriterion("AgreeNote between", value1, value2, "agreeNote");
            return (Criteria) this;
        }

        public Criteria andAgreeNoteNotBetween(String value1, String value2) {
            addCriterion("AgreeNote not between", value1, value2, "agreeNote");
            return (Criteria) this;
        }

        public Criteria andAgreeStateIsNull() {
            addCriterion("AgreeState is null");
            return (Criteria) this;
        }

        public Criteria andAgreeStateIsNotNull() {
            addCriterion("AgreeState is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeStateEqualTo(String value) {
            addCriterion("AgreeState =", value, "agreeState");
            return (Criteria) this;
        }

        public Criteria andAgreeStateNotEqualTo(String value) {
            addCriterion("AgreeState <>", value, "agreeState");
            return (Criteria) this;
        }

        public Criteria andAgreeStateGreaterThan(String value) {
            addCriterion("AgreeState >", value, "agreeState");
            return (Criteria) this;
        }

        public Criteria andAgreeStateGreaterThanOrEqualTo(String value) {
            addCriterion("AgreeState >=", value, "agreeState");
            return (Criteria) this;
        }

        public Criteria andAgreeStateLessThan(String value) {
            addCriterion("AgreeState <", value, "agreeState");
            return (Criteria) this;
        }

        public Criteria andAgreeStateLessThanOrEqualTo(String value) {
            addCriterion("AgreeState <=", value, "agreeState");
            return (Criteria) this;
        }

        public Criteria andAgreeStateLike(String value) {
            addCriterion("AgreeState like", value, "agreeState");
            return (Criteria) this;
        }

        public Criteria andAgreeStateNotLike(String value) {
            addCriterion("AgreeState not like", value, "agreeState");
            return (Criteria) this;
        }

        public Criteria andAgreeStateIn(List<String> values) {
            addCriterion("AgreeState in", values, "agreeState");
            return (Criteria) this;
        }

        public Criteria andAgreeStateNotIn(List<String> values) {
            addCriterion("AgreeState not in", values, "agreeState");
            return (Criteria) this;
        }

        public Criteria andAgreeStateBetween(String value1, String value2) {
            addCriterion("AgreeState between", value1, value2, "agreeState");
            return (Criteria) this;
        }

        public Criteria andAgreeStateNotBetween(String value1, String value2) {
            addCriterion("AgreeState not between", value1, value2, "agreeState");
            return (Criteria) this;
        }

        public Criteria andAgreeManIsNull() {
            addCriterion("AgreeMan is null");
            return (Criteria) this;
        }

        public Criteria andAgreeManIsNotNull() {
            addCriterion("AgreeMan is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeManEqualTo(String value) {
            addCriterion("AgreeMan =", value, "agreeMan");
            return (Criteria) this;
        }

        public Criteria andAgreeManNotEqualTo(String value) {
            addCriterion("AgreeMan <>", value, "agreeMan");
            return (Criteria) this;
        }

        public Criteria andAgreeManGreaterThan(String value) {
            addCriterion("AgreeMan >", value, "agreeMan");
            return (Criteria) this;
        }

        public Criteria andAgreeManGreaterThanOrEqualTo(String value) {
            addCriterion("AgreeMan >=", value, "agreeMan");
            return (Criteria) this;
        }

        public Criteria andAgreeManLessThan(String value) {
            addCriterion("AgreeMan <", value, "agreeMan");
            return (Criteria) this;
        }

        public Criteria andAgreeManLessThanOrEqualTo(String value) {
            addCriterion("AgreeMan <=", value, "agreeMan");
            return (Criteria) this;
        }

        public Criteria andAgreeManLike(String value) {
            addCriterion("AgreeMan like", value, "agreeMan");
            return (Criteria) this;
        }

        public Criteria andAgreeManNotLike(String value) {
            addCriterion("AgreeMan not like", value, "agreeMan");
            return (Criteria) this;
        }

        public Criteria andAgreeManIn(List<String> values) {
            addCriterion("AgreeMan in", values, "agreeMan");
            return (Criteria) this;
        }

        public Criteria andAgreeManNotIn(List<String> values) {
            addCriterion("AgreeMan not in", values, "agreeMan");
            return (Criteria) this;
        }

        public Criteria andAgreeManBetween(String value1, String value2) {
            addCriterion("AgreeMan between", value1, value2, "agreeMan");
            return (Criteria) this;
        }

        public Criteria andAgreeManNotBetween(String value1, String value2) {
            addCriterion("AgreeMan not between", value1, value2, "agreeMan");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeIsNull() {
            addCriterion("AgreeTime is null");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeIsNotNull() {
            addCriterion("AgreeTime is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeEqualTo(Date value) {
            addCriterionForJDBCDate("AgreeTime =", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("AgreeTime <>", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("AgreeTime >", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("AgreeTime >=", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeLessThan(Date value) {
            addCriterionForJDBCDate("AgreeTime <", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("AgreeTime <=", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeIn(List<Date> values) {
            addCriterionForJDBCDate("AgreeTime in", values, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("AgreeTime not in", values, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("AgreeTime between", value1, value2, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("AgreeTime not between", value1, value2, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andApproveNoteIsNull() {
            addCriterion("ApproveNote is null");
            return (Criteria) this;
        }

        public Criteria andApproveNoteIsNotNull() {
            addCriterion("ApproveNote is not null");
            return (Criteria) this;
        }

        public Criteria andApproveNoteEqualTo(String value) {
            addCriterion("ApproveNote =", value, "approveNote");
            return (Criteria) this;
        }

        public Criteria andApproveNoteNotEqualTo(String value) {
            addCriterion("ApproveNote <>", value, "approveNote");
            return (Criteria) this;
        }

        public Criteria andApproveNoteGreaterThan(String value) {
            addCriterion("ApproveNote >", value, "approveNote");
            return (Criteria) this;
        }

        public Criteria andApproveNoteGreaterThanOrEqualTo(String value) {
            addCriterion("ApproveNote >=", value, "approveNote");
            return (Criteria) this;
        }

        public Criteria andApproveNoteLessThan(String value) {
            addCriterion("ApproveNote <", value, "approveNote");
            return (Criteria) this;
        }

        public Criteria andApproveNoteLessThanOrEqualTo(String value) {
            addCriterion("ApproveNote <=", value, "approveNote");
            return (Criteria) this;
        }

        public Criteria andApproveNoteLike(String value) {
            addCriterion("ApproveNote like", value, "approveNote");
            return (Criteria) this;
        }

        public Criteria andApproveNoteNotLike(String value) {
            addCriterion("ApproveNote not like", value, "approveNote");
            return (Criteria) this;
        }

        public Criteria andApproveNoteIn(List<String> values) {
            addCriterion("ApproveNote in", values, "approveNote");
            return (Criteria) this;
        }

        public Criteria andApproveNoteNotIn(List<String> values) {
            addCriterion("ApproveNote not in", values, "approveNote");
            return (Criteria) this;
        }

        public Criteria andApproveNoteBetween(String value1, String value2) {
            addCriterion("ApproveNote between", value1, value2, "approveNote");
            return (Criteria) this;
        }

        public Criteria andApproveNoteNotBetween(String value1, String value2) {
            addCriterion("ApproveNote not between", value1, value2, "approveNote");
            return (Criteria) this;
        }

        public Criteria andApproveStateIsNull() {
            addCriterion("ApproveState is null");
            return (Criteria) this;
        }

        public Criteria andApproveStateIsNotNull() {
            addCriterion("ApproveState is not null");
            return (Criteria) this;
        }

        public Criteria andApproveStateEqualTo(String value) {
            addCriterion("ApproveState =", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateNotEqualTo(String value) {
            addCriterion("ApproveState <>", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateGreaterThan(String value) {
            addCriterion("ApproveState >", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateGreaterThanOrEqualTo(String value) {
            addCriterion("ApproveState >=", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateLessThan(String value) {
            addCriterion("ApproveState <", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateLessThanOrEqualTo(String value) {
            addCriterion("ApproveState <=", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateLike(String value) {
            addCriterion("ApproveState like", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateNotLike(String value) {
            addCriterion("ApproveState not like", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateIn(List<String> values) {
            addCriterion("ApproveState in", values, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateNotIn(List<String> values) {
            addCriterion("ApproveState not in", values, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateBetween(String value1, String value2) {
            addCriterion("ApproveState between", value1, value2, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateNotBetween(String value1, String value2) {
            addCriterion("ApproveState not between", value1, value2, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveManIsNull() {
            addCriterion("ApproveMan is null");
            return (Criteria) this;
        }

        public Criteria andApproveManIsNotNull() {
            addCriterion("ApproveMan is not null");
            return (Criteria) this;
        }

        public Criteria andApproveManEqualTo(String value) {
            addCriterion("ApproveMan =", value, "approveMan");
            return (Criteria) this;
        }

        public Criteria andApproveManNotEqualTo(String value) {
            addCriterion("ApproveMan <>", value, "approveMan");
            return (Criteria) this;
        }

        public Criteria andApproveManGreaterThan(String value) {
            addCriterion("ApproveMan >", value, "approveMan");
            return (Criteria) this;
        }

        public Criteria andApproveManGreaterThanOrEqualTo(String value) {
            addCriterion("ApproveMan >=", value, "approveMan");
            return (Criteria) this;
        }

        public Criteria andApproveManLessThan(String value) {
            addCriterion("ApproveMan <", value, "approveMan");
            return (Criteria) this;
        }

        public Criteria andApproveManLessThanOrEqualTo(String value) {
            addCriterion("ApproveMan <=", value, "approveMan");
            return (Criteria) this;
        }

        public Criteria andApproveManLike(String value) {
            addCriterion("ApproveMan like", value, "approveMan");
            return (Criteria) this;
        }

        public Criteria andApproveManNotLike(String value) {
            addCriterion("ApproveMan not like", value, "approveMan");
            return (Criteria) this;
        }

        public Criteria andApproveManIn(List<String> values) {
            addCriterion("ApproveMan in", values, "approveMan");
            return (Criteria) this;
        }

        public Criteria andApproveManNotIn(List<String> values) {
            addCriterion("ApproveMan not in", values, "approveMan");
            return (Criteria) this;
        }

        public Criteria andApproveManBetween(String value1, String value2) {
            addCriterion("ApproveMan between", value1, value2, "approveMan");
            return (Criteria) this;
        }

        public Criteria andApproveManNotBetween(String value1, String value2) {
            addCriterion("ApproveMan not between", value1, value2, "approveMan");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIsNull() {
            addCriterion("ApproveTime is null");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIsNotNull() {
            addCriterion("ApproveTime is not null");
            return (Criteria) this;
        }

        public Criteria andApproveTimeEqualTo(Date value) {
            addCriterionForJDBCDate("ApproveTime =", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ApproveTime <>", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ApproveTime >", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ApproveTime >=", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeLessThan(Date value) {
            addCriterionForJDBCDate("ApproveTime <", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ApproveTime <=", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIn(List<Date> values) {
            addCriterionForJDBCDate("ApproveTime in", values, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ApproveTime not in", values, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ApproveTime between", value1, value2, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ApproveTime not between", value1, value2, "approveTime");
            return (Criteria) this;
        }

        public Criteria andIsOverIsNull() {
            addCriterion("IsOver is null");
            return (Criteria) this;
        }

        public Criteria andIsOverIsNotNull() {
            addCriterion("IsOver is not null");
            return (Criteria) this;
        }

        public Criteria andIsOverEqualTo(Boolean value) {
            addCriterion("IsOver =", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverNotEqualTo(Boolean value) {
            addCriterion("IsOver <>", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverGreaterThan(Boolean value) {
            addCriterion("IsOver >", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsOver >=", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverLessThan(Boolean value) {
            addCriterion("IsOver <", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverLessThanOrEqualTo(Boolean value) {
            addCriterion("IsOver <=", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverIn(List<Boolean> values) {
            addCriterion("IsOver in", values, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverNotIn(List<Boolean> values) {
            addCriterion("IsOver not in", values, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverBetween(Boolean value1, Boolean value2) {
            addCriterion("IsOver between", value1, value2, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsOver not between", value1, value2, "isOver");
            return (Criteria) this;
        }

        public Criteria andFeedBackIsNull() {
            addCriterion("FeedBack is null");
            return (Criteria) this;
        }

        public Criteria andFeedBackIsNotNull() {
            addCriterion("FeedBack is not null");
            return (Criteria) this;
        }

        public Criteria andFeedBackEqualTo(String value) {
            addCriterion("FeedBack =", value, "feedBack");
            return (Criteria) this;
        }

        public Criteria andFeedBackNotEqualTo(String value) {
            addCriterion("FeedBack <>", value, "feedBack");
            return (Criteria) this;
        }

        public Criteria andFeedBackGreaterThan(String value) {
            addCriterion("FeedBack >", value, "feedBack");
            return (Criteria) this;
        }

        public Criteria andFeedBackGreaterThanOrEqualTo(String value) {
            addCriterion("FeedBack >=", value, "feedBack");
            return (Criteria) this;
        }

        public Criteria andFeedBackLessThan(String value) {
            addCriterion("FeedBack <", value, "feedBack");
            return (Criteria) this;
        }

        public Criteria andFeedBackLessThanOrEqualTo(String value) {
            addCriterion("FeedBack <=", value, "feedBack");
            return (Criteria) this;
        }

        public Criteria andFeedBackLike(String value) {
            addCriterion("FeedBack like", value, "feedBack");
            return (Criteria) this;
        }

        public Criteria andFeedBackNotLike(String value) {
            addCriterion("FeedBack not like", value, "feedBack");
            return (Criteria) this;
        }

        public Criteria andFeedBackIn(List<String> values) {
            addCriterion("FeedBack in", values, "feedBack");
            return (Criteria) this;
        }

        public Criteria andFeedBackNotIn(List<String> values) {
            addCriterion("FeedBack not in", values, "feedBack");
            return (Criteria) this;
        }

        public Criteria andFeedBackBetween(String value1, String value2) {
            addCriterion("FeedBack between", value1, value2, "feedBack");
            return (Criteria) this;
        }

        public Criteria andFeedBackNotBetween(String value1, String value2) {
            addCriterion("FeedBack not between", value1, value2, "feedBack");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("Email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("Email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("Email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("Email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("Email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("Email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("Email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("Email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("Email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("Email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("Email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("Email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("Email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("Email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andHireFilesIsNull() {
            addCriterion("HireFiles is null");
            return (Criteria) this;
        }

        public Criteria andHireFilesIsNotNull() {
            addCriterion("HireFiles is not null");
            return (Criteria) this;
        }

        public Criteria andHireFilesEqualTo(String value) {
            addCriterion("HireFiles =", value, "hireFiles");
            return (Criteria) this;
        }

        public Criteria andHireFilesNotEqualTo(String value) {
            addCriterion("HireFiles <>", value, "hireFiles");
            return (Criteria) this;
        }

        public Criteria andHireFilesGreaterThan(String value) {
            addCriterion("HireFiles >", value, "hireFiles");
            return (Criteria) this;
        }

        public Criteria andHireFilesGreaterThanOrEqualTo(String value) {
            addCriterion("HireFiles >=", value, "hireFiles");
            return (Criteria) this;
        }

        public Criteria andHireFilesLessThan(String value) {
            addCriterion("HireFiles <", value, "hireFiles");
            return (Criteria) this;
        }

        public Criteria andHireFilesLessThanOrEqualTo(String value) {
            addCriterion("HireFiles <=", value, "hireFiles");
            return (Criteria) this;
        }

        public Criteria andHireFilesLike(String value) {
            addCriterion("HireFiles like", value, "hireFiles");
            return (Criteria) this;
        }

        public Criteria andHireFilesNotLike(String value) {
            addCriterion("HireFiles not like", value, "hireFiles");
            return (Criteria) this;
        }

        public Criteria andHireFilesIn(List<String> values) {
            addCriterion("HireFiles in", values, "hireFiles");
            return (Criteria) this;
        }

        public Criteria andHireFilesNotIn(List<String> values) {
            addCriterion("HireFiles not in", values, "hireFiles");
            return (Criteria) this;
        }

        public Criteria andHireFilesBetween(String value1, String value2) {
            addCriterion("HireFiles between", value1, value2, "hireFiles");
            return (Criteria) this;
        }

        public Criteria andHireFilesNotBetween(String value1, String value2) {
            addCriterion("HireFiles not between", value1, value2, "hireFiles");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("PayType is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("PayType is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("PayType =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("PayType <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("PayType >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PayType >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("PayType <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("PayType <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("PayType in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("PayType not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("PayType between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("PayType not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andContractTimeIsNull() {
            addCriterion("ContractTime is null");
            return (Criteria) this;
        }

        public Criteria andContractTimeIsNotNull() {
            addCriterion("ContractTime is not null");
            return (Criteria) this;
        }

        public Criteria andContractTimeEqualTo(Date value) {
            addCriterion("ContractTime =", value, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeNotEqualTo(Date value) {
            addCriterion("ContractTime <>", value, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeGreaterThan(Date value) {
            addCriterion("ContractTime >", value, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ContractTime >=", value, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeLessThan(Date value) {
            addCriterion("ContractTime <", value, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeLessThanOrEqualTo(Date value) {
            addCriterion("ContractTime <=", value, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeIn(List<Date> values) {
            addCriterion("ContractTime in", values, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeNotIn(List<Date> values) {
            addCriterion("ContractTime not in", values, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeBetween(Date value1, Date value2) {
            addCriterion("ContractTime between", value1, value2, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeNotBetween(Date value1, Date value2) {
            addCriterion("ContractTime not between", value1, value2, "contractTime");
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