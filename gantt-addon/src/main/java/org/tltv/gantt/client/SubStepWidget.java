/*
 * Copyright 2015 Tomi Virtanen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.tltv.gantt.client;

import com.vaadin.polymer.elemental.Function;

/**
 * Widget representing a one Sub-Step in the Gantt chart.
 *
 * @author Tltv
 *
 */
public class SubStepWidget extends AbstractStepWidget {

    public static final String STYLE_SUB_BAR = "sub-bar";

    private StepWidget owner;

    public SubStepWidget() {
        super();
        ready(new Function<Object, Object>() {
            @Override
            public Object call(Object arg) {
                getBar().addClassName(STYLE_SUB_BAR);
                return null;
            }
        });
    }

    public void setOwner(StepWidget stepWidget) {
        owner = stepWidget;
        if (owner != null && owner.getGanttWidget() != null) {
            setGantt(owner.getGanttWidget(), owner.getLocaleDataProvider());
        }
    }

    public StepWidget getOwner() {
        return owner;
    }

    @Override
    public String getLeftPositionPercentageStringForDate(Long start, Long end) {
        return gantt.getSubstepLeftPositionPercentageStringForDate(start, end, getOwner().getStep().getStartDate(),
                getOwner().getStep().getEndDate(), getBar());
    }

    @Override
    public String getWidthPercentageStringForDateInterval(Long start, Long end) {
        return gantt.getSubstepWidthPercentageStringForDateInterval(start, end, getOwner().getStep().getStartDate(),
                getOwner().getStep().getEndDate());
    }

}
