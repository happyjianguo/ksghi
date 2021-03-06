/*
 * Copyright 2004 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jmesa.limit;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * <p>
 * The FilterSet is an Collection of Filter objects. A Filter contains a bean
 * property and the filter value. Or, in other words, it is simply the column
 * that the user is trying to filter and the value that they entered.
 * </p>
 *
 * @author Jeff Johnston
 * @since 2.0
 */
public class FilterSet implements Serializable {
    private Set<Filter> filters;

    public FilterSet() {
        filters = new HashSet<Filter>();
    }

    /**
     * @param filter The Filter to add to the set.
     */
    public void addFilter(Filter filter) {
        if (filters.contains(filter)) {
            filters.remove(filter);
        }

        filters.add(filter);
    }

    /**
     * <p>
     * The Filter to add to the set.
     * </p>
     *
     * @param property The column property to filter.
     * @param value    The value to filter the column.
     */
    public void addFilter(String property, String value) {
        addFilter(new Filter(property, value));
    }

    /**
     * <p>
     * For a given item property, retrieve the Filter object based on the
     * property.
     * </p>
     *
     * @param property The Filter property, which is also a column property.
     * @return The Filter object.
     */
    public Filter getFilter(String property) {
        for (Iterator<Filter> iter = filters.iterator(); iter.hasNext(); ) {
            Filter filter = iter.next();
            if (filter.getProperty().equals(property)) {
                return filter;
            }
        }

        return null;
    }

    /**
     * @return The set of Filter objects.
     */
    public Collection<Filter> getFilters() {
        return filters;
    }

    /**
     * <p>
     * For a given property, retrieve the Filter value.
     * </p>
     *
     * @param property The Filter property, which is also a column property.
     * @return The Filter value.
     */
    public String getFilterValue(String property) {
        return getFilter(property).getValue();
    }

    public boolean isFilterable() {
        return isFiltered();
    }

    /**
     * @return Is true if there are any columns that need to be filtered.
     */
    public boolean isFiltered() {
        return filters != null && !filters.isEmpty();
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this);

        for (Iterator<Filter> iter = filters.iterator(); iter.hasNext(); ) {
            Filter filter = iter.next();
            builder.append(filter.toString());
        }

        return builder.toString();
    }
}
