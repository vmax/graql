/*
 * Copyright (C) 2020 Grakn Labs
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
 */

package graql.lang.query;

import graql.lang.common.GraqlToken;
import graql.lang.pattern.variable.ThingVariable;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class GraqlInsert extends GraqlWritable {

    public GraqlInsert(List<ThingVariable<?>> variables) {
        this(null, variables);
    }

    GraqlInsert(@Nullable GraqlMatch.Unfiltered match, List<ThingVariable<?>> variables) {
        super(GraqlToken.Command.INSERT, match, variables);
    }

    public Optional<GraqlMatch.Unfiltered> match() {
        return Optional.ofNullable(super.nullableMatch());
    }
}
