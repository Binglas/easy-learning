package joaozao.sourcedev.com.easylearning.inductions;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import joaozao.sourcedev.com.easylearning.R;
import joaozao.sourcedev.com.easylearning.data.Induction;

public class InductionsAdapter extends RecyclerView.Adapter<InductionsAdapter.ViewHolder>{

    private Context context;
    private List<Induction> inductionList;
    private String imageUrl;

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title) TextView title;
        @BindView(R.id.thumbnail) ImageView thumbnail;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    InductionsAdapter(Context context, List<Induction> inductionList) {
        this.context = context;
        this.inductionList = inductionList;
    }

    void replaceData(List<Induction> inductions) {
        setList(inductions);
        notifyDataSetChanged();
    }

    private void setList(List<Induction> inductions) {
        if (inductions != null) {
            inductionList = inductions;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inductions_list_item, parent, false);

        imageUrl = "http://4.bp.blogspot.com/-8v_k_fOcfP8/UQIL4ufghBI/AAAAAAAAEDo/9ffRRTM9AnA/s1600/android-robog-alone.png";

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Induction induction = inductionList.get(position);
        holder.title.setText(induction.getmInductionName());
        Picasso.with(context).load(imageUrl).placeholder(R.drawable.ic_launcher_background).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return inductionList.size();
    }

}
