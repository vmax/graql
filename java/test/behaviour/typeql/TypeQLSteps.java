/*
 * Copyright (C) 2021 Vaticle
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package com.vaticle.typeql.lang.test.behaviour.typeql;

import com.vaticle.typeql.lang.TypeQL;
import com.vaticle.typeql.lang.query.TypeQLDefine;
import com.vaticle.typeql.lang.query.TypeQLDelete;
import com.vaticle.typeql.lang.query.TypeQLInsert;
import com.vaticle.typeql.lang.query.TypeQLMatch;
import com.vaticle.typeql.lang.query.TypeQLQuery;
import com.vaticle.typeql.lang.query.TypeQLUndefine;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TypeQLSteps {

    @Given("typeql define")
    @Given("typeql define without commit")
    @Given("for each session, typeql define")
    public void typeql_define(String query) {
        TypeQLDefine parsed = TypeQL.parseQuery(query);
        assertEquals(parsed, TypeQL.parseQuery(parsed.toString()));
    }

    @Given("typeql undefine")
    @Given("typeql undefine without commit")
    public void typeql_undefine(String query) {
        TypeQLUndefine parsed = TypeQL.parseQuery(query);
        assertEquals(parsed, TypeQL.parseQuery(parsed.toString()));
    }

    @Given("typeql insert")
    @Given("get answers of typeql insert")
    @Given("typeql insert without commit")
    @Given("for each session, typeql insert")
    public void typeql_insert(String query) {
        TypeQLInsert parsed = TypeQL.parseQuery(query);
        assertEquals(parsed, TypeQL.parseQuery(parsed.toString()));
        parsed.match().ifPresent(match -> match.conjunction().normalise());
    }

    @Given("typeql delete")
    public void typeql_delete(String query) {
        TypeQLDelete parsed = TypeQL.parseQuery(query);
        assertEquals(parsed, TypeQL.parseQuery(parsed.toString()));
        parsed.match().conjunction().normalise();
    }

    @Given("for typeql query")
    @Given("get answers of typeql match")
    @Given("get answers of typeql match group")
    @Given("get answer of typeql match aggregate")
    @Given("get answers of typeql match group aggregate")
    @Given("answer set is equivalent for typeql query")
    public void typeql_match(String query) {
        TypeQLQuery parsed = TypeQL.parseQuery(query);
        assertEquals(parsed, TypeQL.parseQuery(parsed.toString()));
        if (parsed instanceof TypeQLMatch) {
            parsed.asMatch().conjunction().normalise();
        }
    }

    @Given("typeql match throws")
    @Given("typeql insert throws")
    @Given("typeql delete throws")
    @Given("typeql define throws")
    @Given("typeql undefine throws")
    @Given("typeql match; throws exception")
    @Given("typeql match group; throws exception")
    @Given("typeql match aggregate; throws exception")
    @Given("typeql insert; throws exception")
    @Given("typeql delete; throws exception")
    @Given("typeql define; throws exception")
    @Given("typeql undefine; throws exception")
    public void do_nothing_with_throws(String query) {}

    @Given("transaction commits")
    @Given("aggregate answer is not a number")
    @Given("connection has been opened")
    @Given("transaction is initialised")
    @Given("the integrity is validated")
    @Given("connection close all sessions")
    @Given("connection delete all databases")
    @Given("materialised database is completed")
    @Given("for each session, transaction closes")
    @Given("transaction commits; throws exception")
    @Given("connection does not have any database")
    @Given("for each session, transaction commits")
    @Given("all answers are correct in reasoned database")
    @Given("materialised and reasoned databases are the same size")
    public void do_nothing() {}

    @Given("rules contain: {}")
    @Given("answer size is: {}")
    @Given("each answer satisfies")
    @Given("aggregate value is: {}")
    @Given("number of groups is: {}")
    @Given("rules do not contain: {}")
    @Given("each answer does not satisfy")
    @Given("reasoned database is named: {}")
    @Given("connection create database: {}")
    @Given("session transaction is open: {}")
    @Given("materialised database is named: {}")
    @Given("session opens transaction of type: {}")
    @Given("answer size in reasoned database is: {}")
    @Given("connection open data session for database: {}")
    @Given("connection open schema session for database: {}")
    @Given("for each session, open transactions of type: {}")
    @Given("for each session, open transactions with reasoning of type: {}")
    @Given("answers are consistent across {} executions in reasoned database")
    public void do_nothing_with_arg(String ignored) {}

    @Given("connection open data sessions for databases:")
    @Given("connection open schema sessions for databases:")
    public void do_nothing_with_list(List<String> ignored) {}

    @Given("answer groups are")
    @Given("group aggregate values are")
    @Given("order of answer concepts is")
    @Given("uniquely identify answer concepts")
    public void do_nothing_with_list_of_map(List<Map<String, String>> ignored) {}

    @Given("rules are")
    @Given("group identifiers are")
    @Given("concept identifiers are")
    @Given("answers contain explanation tree")
    public void do_nothing_with_map_of_map(Map<String, Map<String, String>> ignored) {}
}