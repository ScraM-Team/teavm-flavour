/*
 *  Copyright 2015 Alexey Andreev.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.teavm.flavour.expr.ast;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpr extends Expr {
    private List<BoundVariable> boundVariables = new ArrayList<>();
    private Expr body;

    public LambdaExpr(Expr body, List<BoundVariable> boundVariables) {
        this.body = body;
        this.boundVariables.addAll(boundVariables);
    }

    public Expr getBody() {
        return body;
    }

    public void setBody(Expr body) {
        this.body = body;
    }

    public List<BoundVariable> getBoundVariables() {
        return boundVariables;
    }

    @Override
    public <T> T acceptVisitor(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
