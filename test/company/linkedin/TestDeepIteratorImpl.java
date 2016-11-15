package company.linkedin;

import com.webmihir.DataProviderSrc;
import com.webmihir.company.linkedin.Data;
import com.webmihir.company.linkedin.DeepIteratorImpl;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.testng.annotations.Test;

import static com.webmihir.AssertHelper.Assert;
import static com.webmihir.AssertHelper.AssertEquals;

public class TestDeepIteratorImpl {
  @Test
  public void testDeepIterator() {
    List<Data<Integer>> list = new LinkedList<>();

    Data<Integer> d1 = new Data<Integer>() {
      @Override
      public boolean isCollection() {
        return false;
      }

      @Override
      public Collection<Data<Integer>> getCollection() {
        return null;
      }

      @Override
      public Integer getElement() {
        return 1;
      }

      @Override
      public String toString() {
        return "1";
      }
    };

    Data<Integer> d2 = new Data<Integer>() {
      @Override
      public boolean isCollection() {
        return true;
      }

      @Override
      public Collection<Data<Integer>> getCollection() {
        List<Data<Integer>> data = new LinkedList<>();

        Data<Integer> e1 = new Data<Integer>() {
          @Override
          public boolean isCollection() {
            return false;
          }

          @Override
          public Collection<Data<Integer>> getCollection() {
            return null;
          }

          @Override
          public Integer getElement() {
            return 2;
          }

          @Override
          public String toString() {
            return "2";
          }
        };

        Data<Integer> e2 = new Data<Integer>() {
          @Override
          public boolean isCollection() {
            return false;
          }

          @Override
          public Collection<Data<Integer>> getCollection() {
            return null;
          }

          @Override
          public Integer getElement() {
            return 3;
          }

          @Override
          public String toString() {
            return "3";
          }
        };

        data.add(e1);
        data.add(e2);

        return data;
      }

      @Override
      public Integer getElement() {
        return null;
      }

      @Override
      public String toString() {
        return "(2,3)";
      }
    };

    Data<Integer> d3 = new Data<Integer>() {
      @Override
      public boolean isCollection() {
        return false;
      }

      @Override
      public Collection<Data<Integer>> getCollection() {
        return null;
      }

      @Override
      public Integer getElement() {
        return 4;
      }

      @Override
      public String toString() {
        return "4";
      }
    };

    list.add(d1);
    list.add(d2);
    list.add(d3);

    DeepIteratorImpl<Integer> deepIterator = new DeepIteratorImpl<>(list);

    while (deepIterator.hasNext()) {
      System.out.println(deepIterator.next());
    }
  }
}
