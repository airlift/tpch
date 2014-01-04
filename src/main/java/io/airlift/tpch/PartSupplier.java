/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.airlift.tpch;

import static io.airlift.tpch.GenerateUtils.formatMoney;

public class PartSupplier
        implements TpchEntity
{
    private final long partKey;
    private final long supplierKey;
    private final long availableQuantity;
    private final long supplyCost;
    private final String comment;

    public PartSupplier(long partKey, long supplierKey, long availableQuantity, long supplyCost, String comment)
    {
        this.partKey = partKey;
        this.supplierKey = supplierKey;
        this.availableQuantity = availableQuantity;
        this.supplyCost = supplyCost;
        this.comment = comment;
    }

    public long getPartKey()
    {
        return partKey;
    }

    public long getSupplierKey()
    {
        return supplierKey;
    }

    public long getAvailableQuantity()
    {
        return availableQuantity;
    }

    public double getSupplyCost()
    {
        return supplyCost / 100.0;
    }

    public String getComment()
    {
        return comment;
    }

    public String toLine()
    {
        return String.format("%d|%d|%d|%s|%s|",
                partKey,
                supplierKey,
                availableQuantity,
                formatMoney(supplyCost),
                comment);
    }
}
