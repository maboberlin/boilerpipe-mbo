/**
 * boilerpipe
 *
 * Copyright (c) 2009, 2014 Christian Kohlschütter
 *
 * The author licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.maboberlin.boilerpipe.filters.simple;

import com.github.maboberlin.boilerpipe.document.TextBlock;
import com.github.maboberlin.boilerpipe.document.TextDocument;
import java.util.List;

import com.github.maboberlin.boilerpipe.BoilerpipeFilter;
import com.github.maboberlin.boilerpipe.BoilerpipeProcessingException;

/**
 * Reverts the "isContent" flag for all {@link TextBlock}s
 */
public final class InvertedFilter implements BoilerpipeFilter {
  public static final InvertedFilter INSTANCE = new InvertedFilter();

  private InvertedFilter() {
  }

  public boolean process(TextDocument doc) throws BoilerpipeProcessingException {

    List<TextBlock> tbs = doc.getTextBlocks();
    if (tbs.isEmpty()) {
      return false;
    }
    for (TextBlock tb : tbs) {
      tb.setIsContent(!tb.isContent());
    }

    return true;
  }

}
